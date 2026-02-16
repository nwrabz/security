package org.wrabz.sec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PostMapping("/a")
    public String postEndpointA() {
        return "Works!";
    }
    @GetMapping("/a")
    public String getEndpointA() {
        return "Works!";
    }
    @GetMapping("/a/b")
    public String getEndpointB() {
        return "Works!";
    }
    @GetMapping("/a/b/c")
    public String getEndpointC() {
        return "Works!";
    }

    @GetMapping("/error")
    public String error() {
        return "Error";
    }
}
