package com.clockin.clockin_backend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@CrossOrigin
@RestController
public class HomeController {

    @RequestMapping({"/hello"})
    public String hello() {
        return "Hello World";
    }

}
