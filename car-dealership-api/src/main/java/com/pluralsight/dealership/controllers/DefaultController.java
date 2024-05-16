package com.pluralsight.dealership.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String welcome() {
        return "Welcome to the Car Dealership API!";
    }
}
