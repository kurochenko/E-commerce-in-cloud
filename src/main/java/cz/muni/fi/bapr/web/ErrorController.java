package cz.muni.fi.bapr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/404")
    public String render404() {
        return "error.404";
    }

    @RequestMapping("/403")
    public String render403() {
        return "error.403";
    }

}
