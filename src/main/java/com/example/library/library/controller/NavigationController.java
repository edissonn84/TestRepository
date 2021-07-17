package com.example.library.library.controller;

import com.example.library.library.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NavigationController {

    private UserService userService;

    public NavigationController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/references")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String references() {
        return "references/references";
    }

    @GetMapping("/statistics")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String statistics() {
        return "statistics";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
