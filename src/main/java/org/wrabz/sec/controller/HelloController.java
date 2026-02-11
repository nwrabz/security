package org.wrabz.sec.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.concurrent.DelegatingSecurityContextCallable;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() throws  Exception {
        Callable<String> task = () -> {
            SecurityContext context = SecurityContextHolder.getContext();
            return "Hello " + context.getAuthentication().getName() + "!";
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        executor = new DelegatingSecurityContextExecutorService(executor);

        try {
            return "Hello, " + executor.submit(task).get() + "!";
        } finally {
            executor.shutdown();
        }
    }
}
