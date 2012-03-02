package cz.muni.fi.bapr.web;

import cz.muni.fi.bapr.entity.Product;
import cz.muni.fi.bapr.service.ProductService;
import cz.muni.fi.bapr.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    public static final String MODEL_PRODUCT = "product";
    public static final String MODEL_VAT_PRICE = "vatPrice";

    @Autowired
    private ProductService productService;


    @RequestMapping("/detail/{id}")
    public String renderDetail(@PathVariable("id") Long id, Model model) {

        Product product = productService.find(id);
        model.addAttribute(MODEL_PRODUCT, product);
        model.addAttribute(MODEL_VAT_PRICE, Utils.getVatPrice(product.getPrice(), product.getVat().getVat()));
        return "product.detail";
    }

}
