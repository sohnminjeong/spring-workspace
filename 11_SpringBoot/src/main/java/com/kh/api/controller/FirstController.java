package com.kh.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/first")
    public String first(Model model){
        model.addAttribute("name", "비둘기");
        return "first";
    }


}
