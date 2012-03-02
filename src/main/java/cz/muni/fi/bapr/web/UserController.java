package cz.muni.fi.bapr.web;

import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.entity.UserPrivilege;
import cz.muni.fi.bapr.security.UserRoles;
import cz.muni.fi.bapr.service.CustomerService;
import cz.muni.fi.bapr.service.UserPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Controller
public class UserController {

    public static final String MODEL_ATTR_USER = "user";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserPrivilegeService userPrivilegeService;

    @Autowired
    @Qualifier("customerValidator")
    private Validator validator;


    @RequestMapping("/register")
    public String renderRegister(Model model) {
        model.addAttribute(MODEL_ATTR_USER, new Customer());

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createCustomer(@ModelAttribute(MODEL_ATTR_USER) Customer customer, BindingResult result) {

        customer.setCreated(Calendar.getInstance().getTime());
        customer.setPassword(passwordEncoder.encodePassword(customer.getPassword(), null));

        validator.validate(customer, result);

        if (result.hasErrors()) {
            return "register";
        }

        if (customerService.count() == 0) {
            List<UserPrivilege> privileges = new ArrayList<UserPrivilege>();
            privileges.add(userPrivilegeService.findByName(UserRoles.ROLE_ADMIN));
            customer.setPrivileges(privileges);
        }

        customerService.create(customer);
        return "redirect:/";
    }

    @RequestMapping("/login")
    public String renderLogin() {
        return "login";
    }
}
