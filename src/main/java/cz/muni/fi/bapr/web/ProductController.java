package cz.muni.fi.bapr.web;

import cz.muni.fi.bapr.entity.Cart;
import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.entity.Product;
import cz.muni.fi.bapr.security.User;
import cz.muni.fi.bapr.service.CartService;
import cz.muni.fi.bapr.service.CustomerService;
import cz.muni.fi.bapr.service.ProductService;
import cz.muni.fi.bapr.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    private User user;

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;


    @RequestMapping("/detail/{id}")
    public String renderDetail(@PathVariable("id") Long id, Model model) {

        Product product = productService.find(id);
        model.addAttribute(MODEL_PRODUCT, product);
        model.addAttribute(MODEL_VAT_PRICE, Utils.getVatPrice(product.getPrice(), product.getVat().getVat()));
        return "product.detail";
    }

    @RequestMapping("/add/{id}")
    @PreAuthorize("isAuthenticated()")
    public String addProductToCart(@PathVariable("id") Long id) {

        Customer customer = customerService.find(user.getId());
        Product product = productService.find(id);

        Cart cart = cartService.matchCustomerProduct(customer, product);

        if (cart == null) {
            cart = new Cart();
            cart.setCustomer(customer);
            cart.setProduct(product);
            cart.setAmount(1);
            cartService.create(cart);
        } else {
            cart.setAmount(cart.getAmount() + 1);
            cartService.edit(cart);
        }

        return "redirect:/product/detail/" + id;
    }

}
