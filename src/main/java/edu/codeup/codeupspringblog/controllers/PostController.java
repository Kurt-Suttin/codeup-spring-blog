package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/posts")
@Controller
public class PostController {


    @GetMapping("")
    @ResponseBody
    public String indexPage() {
        return "posts index page";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String viewIndividualPost(@PathVariable long id) {
        return "view an individual post";
    }

    @GetMapping("/create")
    @ResponseBody
    public String showCreatePostView() {
        return "view an individual post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String CreatePost() {
        return "create a new post";
    }
}
