package pl.arturzaczek.exercise34.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.arturzaczek.exercise34.form.PostNewForm;

@Controller
public class HomeController {
    @GetMapping ("/addNewPost")
    public String getAddNewPostForm (Model model){
        model.addAttribute("newPostForm", new PostNewForm());
        return "post/newPost";
    }
}
