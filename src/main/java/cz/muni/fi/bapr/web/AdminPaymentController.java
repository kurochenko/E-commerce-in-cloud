package cz.muni.fi.bapr.web;

import cz.muni.fi.bapr.entity.PaymentType;
import cz.muni.fi.bapr.security.UserRoles;
import cz.muni.fi.bapr.service.OrderService;
import cz.muni.fi.bapr.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Controller
@RequestMapping("/admin/payment")
@PreAuthorize("hasRole('" + UserRoles.ROLE_ADMIN + "')")
public class AdminPaymentController {

    public static final String MODEL_PAYMENT_LIST = "payments";
    public static final String MODEL_PAYMENT = "payment";
    public static final String ERROR_MSG_ATTR = "errorMsg";

    @Autowired
    private PaymentTypeService paymentTypeService;

    @Autowired
    private OrderService orderService;

    @Autowired
    @Qualifier("paymentValidator")
    private Validator validator;


    @InitBinder
    public void bindValidator(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping("/list")
    public String renderList(Model model) {
        model.addAttribute(MODEL_PAYMENT_LIST, paymentTypeService.findAll());
        return "payment.list";
    }

    @RequestMapping("/create")
    public String renderCreate(Model model) {
        model.addAttribute(MODEL_PAYMENT, new PaymentType());
        return "payment.form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processCreate(@ModelAttribute(MODEL_PAYMENT) @Valid PaymentType paymentType, BindingResult result) {

        if (result.hasErrors()) {
            return "payment.form";
        }

        paymentTypeService.create(paymentType);
        return "redirect:/admin/payment/list";
    }

    @RequestMapping("/edit/{id}")
    public String renderEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute(MODEL_PAYMENT, paymentTypeService.find(id));
        return "payment.form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String processEdit(@ModelAttribute(MODEL_PAYMENT) @Valid PaymentType paymentType, BindingResult result) {

        if (result.hasErrors()) {
            return "payment.form";
        }

        paymentTypeService.edit(paymentType);
        return "redirect:/admin/payment/list";
    }

    @RequestMapping("/delete/{id}")
    public String renderDelete(@PathVariable("id") Long id, Model model) {

        PaymentType paymentType = paymentTypeService.find(id);

        if (!orderService.findByPaymentType(paymentType).isEmpty()) {
            model.addAttribute(ERROR_MSG_ATTR, "order.has.payment.type");
        }

        model.addAttribute(MODEL_PAYMENT, paymentType);
        return "payment.delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String processDelete(@RequestParam("id") Long id) {

        paymentTypeService.remove(paymentTypeService.find(id));
        return "redirect:/admin/payment/list";
    }

}
