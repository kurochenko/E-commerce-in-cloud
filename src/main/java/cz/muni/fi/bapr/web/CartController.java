package cz.muni.fi.bapr.web;

import cz.muni.fi.bapr.entity.Cart;
import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.entity.Product;
import cz.muni.fi.bapr.security.User;
import cz.muni.fi.bapr.service.CartService;
import cz.muni.fi.bapr.service.CustomerService;
import cz.muni.fi.bapr.service.ProductService;
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
@RequestMapping("/cart")
@PreAuthorize("isAuthenticated()")
public class CartController {

    public static final String ACTION_INC = "inc";
    public static final String ACTION_DEC = "dec";
    public static final String MODEL_CART_LIST = "carts";
    public static final String MODEL_CART_STATS = "cartStats";

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private User user;


    @RequestMapping("/list")
    public String renderList(Model model) {

        Customer customer = customerService.find(user.getId());

        model.addAttribute(MODEL_CART_STATS, cartService.sumStats(customer));
        model.addAttribute(MODEL_CART_LIST, cartService.findByCustomer(customer));
        return "cart.list";
    }

    @RequestMapping("/amount/{action}/{id}")
    public String increaseAmount(@PathVariable("action") String action, @PathVariable("id") Long id) {

        Product product = productService.find(id);
        Customer customer = customerService.find(user.getId());

        Cart cart = cartService.matchCustomerProduct(customer, product);

        if (cart != null) {
            if (action.equals(ACTION_INC)) {
                cart.setAmount(cart.getAmount() + 1);
            } else if (action.equals(ACTION_DEC)) {
                cart.setAmount(cart.getAmount() - 1);
            }

            if (cart.getAmount().equals(0)) {
                cartService.remove(cart);
            } else {
                cartService.edit(cart);
            }
        }

        return "redirect:/cart/list";
    }
}
