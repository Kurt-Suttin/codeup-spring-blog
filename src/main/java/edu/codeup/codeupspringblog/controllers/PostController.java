package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Contact;
import edu.codeup.codeupspringblog.models.Post;
import edu.codeup.codeupspringblog.repository.ContactRepository;
import edu.codeup.codeupspringblog.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts/view")
    public String returnPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("")
    public String indexPage(Model model) {
        model.addAttribute("posts",postDao.findAll());
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

    @GetMapping("/posts")
    public List<Post> returnPosts() {
        return postDao.findAll();
    }

    @GetMapping("/create")
    public String showCreatePostView(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/create")
    public String CreatePost(@RequestParam(name = "title")String title ,@RequestParam(name = "body")String body) {
        Post post = new Post(title,body);
        postDao.save(post);
        return "redirect:/posts";
    }


}
