package xyz.xiashuo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Hello")
public class HelloController {

    // http://localhost:8888/SpringBoot-Basic/hello
    @RequestMapping("/sayHello")
    public String sayHello() {
        return "Hello, Spring Boot 2!";
    }

}