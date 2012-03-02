package cz.muni.fi.bapr.web;

import cz.muni.fi.bapr.entity.Category;
import cz.muni.fi.bapr.service.CategoryService;
import cz.muni.fi.bapr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/{id}/list")
    public String listProducts(@PathVariable("id") Long id, Model model) {

        Category category = categoryService.find(id);

        model.addAttribute("category", category);
        if (category != null) {
            model.addAttribute("products", productService.findByCategory(category));
        }

        return "product.list";
    }

}
