package cz.muni.fi.bapr.web;

import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.entity.Order;
import cz.muni.fi.bapr.security.User;
import cz.muni.fi.bapr.security.UserRoles;
import cz.muni.fi.bapr.service.CustomerService;
import cz.muni.fi.bapr.service.OrderProductService;
import cz.muni.fi.bapr.service.OrderService;
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
@RequestMapping("/order")
@PreAuthorize("hasRole('" + UserRoles.ROLE_LOGGED + "')")
public class OrderController {

    public static final String MODEL_ORDERS_NEW = "newOrders";
    public static final String MODEL_ORDERS_OLD = "oldOrders";
    public static final String MODEL_PRODUCTS = "products";
    public static final String MODEL_ORDER = "order";
    public static final String MODEL_STATS = "stats";

    @Autowired
    private User user;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProductService orderProductService;

    @Autowired
    private CustomerService customerService;


    @RequestMapping("/list")
    private String renderList(Model model) {

        Customer customer = customerService.find(user.getId());

        model.addAttribute(MODEL_ORDERS_NEW, orderService.findNotAttendedByCustomer(customer));
        model.addAttribute(MODEL_ORDERS_OLD, orderService.findAttendedByCustomer(customer));

        return "order.list";
    }

    @RequestMapping("/detail/{id}")
    private String renderList(@PathVariable("id") Long id, Model model) {

        Order order = orderService.find(id);


        model.addAttribute(MODEL_ORDER, order);
        model.addAttribute(MODEL_PRODUCTS, orderProductService.findByOrder(order));
        model.addAttribute(MODEL_STATS, orderProductService.sumStats(order));

        return "order.detail";
    }

}
