package edu.codeup.codeupspringblog.controllers;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/hello")
@Controller
public class HelloController {

    @GetMapping("hello/world")
    @ResponseBody
    public String helloWorld() {
        System.out.println("inside hellocontroller helloworld method");
        return "Hello WORLD";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String helloName(@PathVariable String name) {
        return String.format("Hello, %s", name);
    }
}








