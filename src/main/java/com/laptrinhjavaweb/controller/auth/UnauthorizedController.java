package com.laptrinhjavaweb.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnauthorizedController {

    @GetMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }
}
