package com.pluralsight.dealership.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The DefaultController class handles default HTTP requests.
 */
@RestController
public class DefaultController {

    /**
     * Handles GET requests to the root URL ("/") and returns a welcome message.
     *
     * @return A welcome message.
     */
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String welcome() {
        return "Welcome to the Car Dealership API!";
    }
}
