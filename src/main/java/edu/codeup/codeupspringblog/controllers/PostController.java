package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/posts")
@Controller
public class PostController {


    @GetMapping("")
    public String indexPage(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("title1", "body1"));
        posts.add(new Post("title2", "body2"));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/{id}")

    public String viewIndividualPost(@PathVariable long id, Model model) {
        Post post = new Post();
        post.setTitle("title");
        post.setBody("body");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @PostMapping("/create")
    public String CreatePost() {

        return "create a new post";
    }

    @GetMapping("/create")
    public String showCreatePostView() {
        return "view an individual post";
    }


}
