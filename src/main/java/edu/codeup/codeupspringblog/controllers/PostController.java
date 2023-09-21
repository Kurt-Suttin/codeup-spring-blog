package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Post;
import edu.codeup.codeupspringblog.models.User;
import edu.codeup.codeupspringblog.repository.PostRepository;
import edu.codeup.codeupspringblog.repository.UserRepository;
import edu.codeup.codeupspringblog.services.EmailSvc;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    // dependency injection start
    private final EmailSvc emailService;
    private PostRepository postDao;
    private UserRepository userDao;

    // same name as class always

    public PostController(EmailSvc emailService, PostRepository postDao, UserRepository userDao) {
        this.emailService = emailService;
        this.postDao = postDao;
        this.userDao = userDao;
    }


    // dependency injection end

    @GetMapping("/posts/view")
    public String returnPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("")
    public String indexPage(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        if (postDao.existsById(id)) {
            //use .get() anytime you want to get by id
            Post post = postDao.findById(id).get();
            model.addAttribute("post", post);
            return "posts/show";

        }
        return "redirect:/posts";

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
    public String CreatePost(@ModelAttribute Post post) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userDao.findById(loggedInUser.getId()).get();
        Post postToSave = new Post(
                post.getTitle(),
                post.getBody(),
                user

        );
        emailService.prepareAndSend(user, "HELLO", "hello");
        postDao.save(postToSave);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String viewEditPost(@PathVariable long id, Model model) {
        Post postToView = postDao.findById(id).get();
        model.addAttribute("post", postToView);
        return "posts/edit";
    }

    @PostMapping("/{id}/edit")
    public String editPost(@ModelAttribute Post post, @PathVariable long id) {
        Post postToEdit = postDao.findById(id).get();
        postToEdit.setTitle(post.getTitle());
        postToEdit.setBody(post.getBody());
        postDao.save(postToEdit);
        return "redirect:/posts";
    }


}
