package cz.muni.fi.bapr.web;

import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.service.CustomerService;
import cz.muni.fi.bapr.service.UserPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    public static final String MODEL_CUSTOMERS_LIST = "customers";
    public static final String MODEL_CUSTOMER = "customer";
    public static final String MODEL_PRIVILEGES = "privilegesObject";

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserPrivilegeService userPrivilegeService;


    @RequestMapping("/list")
    public String renderList(Model model) {

        model.addAttribute(MODEL_CUSTOMERS_LIST, customerService.findAll());
        return "admin.user.list";
    }

    @RequestMapping("/detail/{id}")
    public String renderDetail(@PathVariable("id") Long id, Model model) {

        model.addAttribute(MODEL_CUSTOMER, customerService.find(id));
        model.addAttribute(MODEL_PRIVILEGES, userPrivilegeService.findAll());
        return "admin.user.detail";
    }

    @RequestMapping("/edit")
    public String processEdit(@ModelAttribute(MODEL_CUSTOMER) Customer customer) {

        Customer fromDB = customerService.find(customer.getId());
        fromDB.setPrivileges(customer.getPrivileges());
        customerService.edit(fromDB);

        return "redirect:/admin/user/list";
    }


}
