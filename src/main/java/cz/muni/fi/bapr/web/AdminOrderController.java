package cz.muni.fi.bapr.web;

import cz.muni.fi.bapr.entity.Order;
import cz.muni.fi.bapr.security.UserRoles;
import cz.muni.fi.bapr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Controller
@RequestMapping("/admin/order")
@PreAuthorize("hasRole('" + UserRoles.ROLE_ADMIN + "')")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping("/attend/{id}")
    public String processAttend(@PathVariable("id") Long id) {

        Order order = orderService.find(id);
        order.setAttended(Calendar.getInstance().getTime());
        orderService.edit(order);

        return "redirect:/admin/order/new";
    }

    @RequestMapping("/new")
    public String renderNew(Model model) {

        model.addAttribute("orders", orderService.findNotAttended());

        return "order.admin.new";
    }

    @RequestMapping("/old")
    public String renderOld(Model model) {

        model.addAttribute("orders", orderService.findAttended());

        return "order.admin.old";
    }

}
