package cz.muni.fi.bapr.web;

import cz.muni.fi.bapr.entity.Cart;
import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.entity.Order;
import cz.muni.fi.bapr.entity.Product;
import cz.muni.fi.bapr.security.User;
import cz.muni.fi.bapr.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Calendar;

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
    public static final String MODEL_ORDER = "order";
    public static final String MODEL_PAYMENT_TYPE_LIST = "paymentTypes";
    public static final String MODEL_DELIVERY_TYPE_LIST = "deliveryTypes";

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PaymentTypeService paymentTypeService;

    @Autowired
    private DeliveryTypeService deliveryTypeService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private User user;

    @Autowired
    @Qualifier("springValidator")
    private Validator validator;


    @RequestMapping("/list")
    public String renderList(Model model) {

        Customer customer = customerService.find(user.getId());

        model.addAttribute(MODEL_CART_STATS, cartService.sumStats(customer));
        model.addAttribute(MODEL_CART_LIST, cartService.findByCustomer(customer));
        model.addAttribute(MODEL_ORDER, new Order());
        model.addAttribute(MODEL_PAYMENT_TYPE_LIST, paymentTypeService.findAll());
        model.addAttribute(MODEL_DELIVERY_TYPE_LIST, deliveryTypeService.findAll());

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

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String createOrder(@ModelAttribute(MODEL_ORDER) Order order, BindingResult bindingResult) {

        Customer customer = customerService.find(user.getId());

        order.setCustomer(customer);
        order.setCreated(Calendar.getInstance().getTime());

        validator.validate(order, bindingResult);
        if (bindingResult.hasErrors()) {
            return "cart.list";
        }

        orderService.createAndMoveProducts(order);
        return "cart.success";
    }
}
