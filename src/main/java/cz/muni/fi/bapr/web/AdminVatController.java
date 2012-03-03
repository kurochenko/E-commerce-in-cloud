package cz.muni.fi.bapr.web;

import cz.muni.fi.bapr.entity.Vat;
import cz.muni.fi.bapr.service.VatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping("/admin/vat")
public class AdminVatController {

    public static final String MODEL_VAT_LIST = "vats";
    public static final String MODEL_VAT = "vatObject";

    @Autowired
    private VatService vatService;

    @Autowired
    @Qualifier("vatValidator")
    private Validator validator;


    @InitBinder
    public void bindValidator(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping("/list")
    public String renderList(Model model) {
        model.addAttribute(MODEL_VAT_LIST, vatService.findAll());
        return "vat.list";
    }

    @RequestMapping("/create")
    public String renderCreate(Model model) {
        model.addAttribute(MODEL_VAT, new Vat());
        return "vat.form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processCreate(@ModelAttribute(MODEL_VAT) @Valid Vat vat, BindingResult result) {
        if (result.hasErrors()) {
            return "vat.form";
        }

        vatService.create(vat);
        return "redirect:/admin/vat/list";
    }

    @RequestMapping("/edit/{id}")
    public String renderEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute(MODEL_VAT, vatService.find(id));
        return "vat.form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String processEdit(@ModelAttribute(MODEL_VAT) @Valid Vat vat, BindingResult result) {

        if (result.hasErrors()) {
            return "vat.form";
        }

        vatService.edit(vat);
        return "redirect:/admin/vat/list";
    }

    @RequestMapping("/delete/{id}")
    public String renderDelete(@PathVariable("id") Long id, Model model) {
        model.addAttribute(MODEL_VAT, vatService.find(id));
        return "vat.delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String processDelete(@RequestParam("id") Long id) {

        vatService.remove(vatService.find(id));
        return "redirect:/admin/vat/list";
    }

}
