package com.laptrinhjavaweb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Dashboards {

    @GetMapping("/admin/dashboard")
    public String dashboard(){
        return "dashboards";
    }
}
