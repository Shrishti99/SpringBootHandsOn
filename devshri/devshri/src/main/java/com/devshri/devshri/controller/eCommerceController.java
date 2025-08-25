package com.devshri.devshri.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class eCommerceController
{
    @GetMapping("/hello")
    public String hello() {
        return "Shrishti Singh!";
    }
}
