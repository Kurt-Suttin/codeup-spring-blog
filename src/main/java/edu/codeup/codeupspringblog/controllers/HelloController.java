package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {

    @GetMapping("hello/world")
    @ResponseBody
    public String helloWorld() {
        System.out.println("inside hellocontroller helloworld method");
        return "Hello WORLD";
    }

//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String helloName(@PathVariable String name) {
//        return String.format("Hello, %s", name);
//    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

//    @GetMapping("/join")
//    public String showJoinForm() {
//        return "join";
//    }

   @GetMapping("/join")
    public String showJoinFrom(Model model){
       List<Item> shoppingCart = new ArrayList<>();
       shoppingCart.add(new Item("drill"));
       shoppingCart.add(new Item("hammer"));
       shoppingCart.add(new Item("screwdriver"));
       model.addAttribute("shoppingCart",shoppingCart);
       return "join";

   }
}








