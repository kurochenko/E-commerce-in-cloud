package cz.muni.fi.bapr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andrej Kuročenko <andrej@kurochenko.net>
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping
    public String renderIndex() {
        return "index";
    }
}
