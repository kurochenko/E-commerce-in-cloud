package cz.muni.fi.bapr.web;

import cz.muni.fi.bapr.entity.Category;
import cz.muni.fi.bapr.service.CategoryService;
import cz.muni.fi.bapr.service.ProductService;
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
@RequestMapping("/admin/category")
public class AdminCategoryController {

    public static final String MODEL_CATEGORY_LIST = "categories";
    public static final String MODEL_CATEGORY = "category";
    public static final String ERROR_MSG_ATTR = "errorMsg";

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    @Qualifier("categoryValidator")
    private Validator validator;


    @InitBinder
    public void bindValidator(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping("/list")
    public String renderList(Model model) {
        model.addAttribute(MODEL_CATEGORY_LIST, categoryService.findAll());
        return "category.list";
    }

    @RequestMapping("/create")
    public String renderCreate(Model model) {
        model.addAttribute(MODEL_CATEGORY, new Category());
        return "category.form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCategory(@ModelAttribute(MODEL_CATEGORY) @Valid Category category, BindingResult result) {

        if (result.hasErrors()) {
            return "category.form";
        }

        categoryService.create(category);
        return "redirect:/admin/category/list";
    }

    @RequestMapping("/edit/{id}")
    public String renderEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute(MODEL_CATEGORY, categoryService.find(id));
        return "category.form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editCategory(@ModelAttribute(MODEL_CATEGORY) @Valid Category category, BindingResult result) {

        if (result.hasErrors()) {
            return "category.form";
        }

        categoryService.edit(category);
        return "redirect:/admin/category/list";
    }

    @RequestMapping("/delete/{id}")
    public String renderDelete(@PathVariable("id") Long id, Model model) {

        Category category = categoryService.find(id);

        if (!productService.findByCategory(category).isEmpty()) {
            model.addAttribute(ERROR_MSG_ATTR, "category.has.product");
        }

        model.addAttribute(MODEL_CATEGORY, category);
        return "category.delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteCategory(@RequestParam("id") Long id) {

        categoryService.remove(categoryService.find(id));
        return "redirect:/admin/category/list";
    }
}
