package pl.arturzaczek.exercise34.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping ("/addNewPost")
    public String getAddNewPostForm (){
        return "post/newPost";
    }
}
