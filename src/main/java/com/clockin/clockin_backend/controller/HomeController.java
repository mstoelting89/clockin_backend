package com.clockin.clockin_backend.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class HomeController {

    @RequestMapping({"/hello"})
    public String hello() {
        return "Hello World";
    }

    @RequestMapping({"/foo"})
    public String bar() {
        return "Bar";
    }

}
