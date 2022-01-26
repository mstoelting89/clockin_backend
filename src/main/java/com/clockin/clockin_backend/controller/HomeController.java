package com.clockin.clockin_backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class HomeController {

    @PostMapping(path = "/api/v1/testendpoint")
    public String getData() {
        return "Data are coming through";
    }

}
