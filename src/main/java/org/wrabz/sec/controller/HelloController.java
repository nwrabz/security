package org.wrabz.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/home")
    public String home() throws  Exception {
            return "Hello, home controller";
    }

    @GetMapping("/hello")
    public String hello() throws  Exception {
        return "Hello, hello controller";
    }

}

