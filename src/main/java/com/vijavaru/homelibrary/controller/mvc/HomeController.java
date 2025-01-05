package com.vijavaru.homelibrary.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/v1/homelibrary")
    public String start(Model model) {
        model.addAttribute("message", "This is Home Library");
        return "home";
    }

}
