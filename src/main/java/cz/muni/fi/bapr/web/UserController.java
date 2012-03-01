package cz.muni.fi.bapr.web;

import cz.muni.fi.bapr.entity.Customer;
import cz.muni.fi.bapr.service.CustomerService;
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

import java.util.Calendar;

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

        customerService.create(customer);
        return "redirect:/";
    }

    @RequestMapping("/login")
    public String renderLogin() {
        return "login";
    }
}
