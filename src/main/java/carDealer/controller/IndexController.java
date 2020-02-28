package carDealer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String indexGet() {
        return "index";
    }

    @RequestMapping("/dev-contact")
    public String devContactGet() {
        return "dev-contact";
    }
}
