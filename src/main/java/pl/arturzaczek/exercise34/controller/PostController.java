package pl.arturzaczek.exercise34.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.arturzaczek.exercise34.form.PostNewForm;
import pl.arturzaczek.exercise34.services.PostService;

import javax.validation.Valid;

@Controller
public class PostController {

    private PostService postService;

    @Autowired
    public PostController (PostService postService){
        this.postService = postService;
    }

    @PostMapping ("/addNewPost")
    public String addNewPost (@ModelAttribute @Valid PostNewForm postNewForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "post/newPost";
        }
        return "redirect:/home";
    }

}
