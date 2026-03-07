package be.ipeters.thinkmaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* carlpeters created on 05/03/2026 inside the package - be.ipeters.thinkmaven */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
//        String viewName = getViewName();
//        return viewName;
        return "index.html";
    }

//    private String getViewName() {
//        return "index";
//    }
}
