package pl.arturzaczek.exercise34.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.arturzaczek.exercise34.entity.Post;
import pl.arturzaczek.exercise34.form.PostNewForm;
import pl.arturzaczek.exercise34.repository.PostRepository;
import pl.arturzaczek.exercise34.services.PostService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PostController {

    private PostService postService;
    private PostRepository postRepository;


    @Autowired
    public PostController (PostService postService, PostRepository postRepository){
        this.postService = postService;
        this.postRepository = postRepository;

    }

    @PostMapping ("/addNewPost")
    public String addNewPost (@ModelAttribute @Valid PostNewForm postNewForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "post/newPost";
        }
        postService.savePost(postNewForm);
        return "redirect:/index";
    }
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    @GetMapping ("/post/showAll")
    public String showAllPosts (Model model){
        List<Post> posts = getAllPosts();
        model.addAttribute("posts", posts);
        return "post/showPosts";
    }
    @GetMapping ("/post/add")
    public String getAddNewPostForm (Model model){
        model.addAttribute("newPostForm", new PostNewForm());
        return "post/newPost";
    }
}
