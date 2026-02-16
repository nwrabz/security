package org.wrabz.sec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello hello";
    }

    @GetMapping("/ciao")
    public String ciao() {
        return "Hello Ciao";
    }

}
