package cz.muni.fi.bapr.web;

import cz.muni.fi.bapr.entity.Category;
import cz.muni.fi.bapr.entity.Product;
import cz.muni.fi.bapr.entity.Vat;
import cz.muni.fi.bapr.service.CategoryService;
import cz.muni.fi.bapr.service.ProductService;
import cz.muni.fi.bapr.service.VatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.List;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Controller
@RequestMapping("/admin/product")
public class AdminProductController {

    public static final String MODEL_PRODUCT = "product";
    public static final String MODEL_CATEGORIES = "categories";
    public static final String MODEL_VATS = "vats";

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private VatService vatService;

    @Autowired
    @Qualifier("springValidator")
    private Validator validator;


    @ModelAttribute(MODEL_CATEGORIES)
    public List<Category> prepareCategories() {
        return categoryService.findAll();
    }

    @ModelAttribute(MODEL_VATS)
    public List<Vat> prepareVats() {
        return vatService.findAll();
    }

    @RequestMapping("/create")
    public String renderCreate(Model model) {

        model.addAttribute(MODEL_PRODUCT, new Product());
        return "product.form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processCreate(@ModelAttribute(MODEL_PRODUCT) Product product, BindingResult result) {

        product.setCreated(Calendar.getInstance().getTime());

        validator.validate(product, result);
        if (result.hasErrors()) {
            return "product.form";
        }

        productService.create(product);
        return "redirect:/product/detail/" + product.getId();
    }

    @RequestMapping("/edit/{id}")
    public String renderEdit(@PathVariable("id") Long id, Model model) {

        model.addAttribute(MODEL_PRODUCT, productService.find(id));
        return "product.form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String processEdit(@ModelAttribute(MODEL_PRODUCT) @Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product.form";
        }

        productService.edit(product);
        return "redirect:/product/detail/" + product.getId();
    }
}
