package cz.muni.fi.bapr.web;

import cz.muni.fi.bapr.entity.DeliveryType;
import cz.muni.fi.bapr.security.UserRoles;
import cz.muni.fi.bapr.service.DeliveryTypeService;
import cz.muni.fi.bapr.service.OrderService;
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
@RequestMapping("/admin/delivery")
@PreAuthorize("hasRole('" + UserRoles.ROLE_ADMIN + "')")
public class AdminDeliveryController {

    public static final String MODEL_DELIVERY_LIST = "deliveries";
    public static final String MODEL_DELIVERY = "delivery";
    public static final String ERROR_MSG_ATTR = "errorMsg";

    @Autowired
    private DeliveryTypeService deliveryTypeService;

    @Autowired
    private OrderService orderService;

    @Autowired
    @Qualifier("deliveryTypeValidator")
    private Validator validator;


    @InitBinder
    public void bindValidator(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping("/list")
    public String renderList(Model model) {
        model.addAttribute(MODEL_DELIVERY_LIST, deliveryTypeService.findAll());
        return "delivery.list";
    }

    @RequestMapping("/create")
    public String renderCreate(Model model) {
        model.addAttribute(MODEL_DELIVERY, new DeliveryType());
        return "delivery.form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processCreate(@ModelAttribute(MODEL_DELIVERY) @Valid DeliveryType deliveryType, BindingResult result) {

        if (result.hasErrors()) {
            return "delivery.form";
        }

        deliveryTypeService.create(deliveryType);
        return "redirect:/admin/delivery/list";
    }

    @RequestMapping("/edit/{id}")
    public String renderEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute(MODEL_DELIVERY, deliveryTypeService.find(id));
        return "delivery.form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String processEdit(@ModelAttribute(MODEL_DELIVERY) @Valid DeliveryType deliveryType, BindingResult result) {

        if (result.hasErrors()) {
            return "delivery.form";
        }

        deliveryTypeService.edit(deliveryType);
        return "redirect:/admin/delivery/list";
    }

    @RequestMapping("/delete/{id}")
    public String renderDelete(@PathVariable("id") Long id, Model model) {

        DeliveryType deliveryType = deliveryTypeService.find(id);

        if (!orderService.findByDeliveryType(deliveryType).isEmpty()) {
            model.addAttribute(ERROR_MSG_ATTR, "order.has.delivery.type");
        }

        model.addAttribute(MODEL_DELIVERY, deliveryType);
        return "delivery.delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String processDelete(@RequestParam("id") Long id) {

        deliveryTypeService.remove(deliveryTypeService.find(id));
        return "redirect:/admin/delivery/list";
    }

}
