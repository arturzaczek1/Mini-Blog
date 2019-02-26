package pl.arturzaczek.exercise34.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.arturzaczek.exercise34.form.UserLoginForm;
import pl.arturzaczek.exercise34.form.UserRegisterForm;


@Controller
public class MainController {

    @RequestMapping("/index")
    public String getIndexPage() {
        System.out.println("request o index.html");
        return "index";
    }

    @GetMapping("/goToLoginForm")
    public String goToLoginForm(Model model) {
        model.addAttribute("userLoginForm", new UserLoginForm());
        return "user/loginForm";
    }

    @GetMapping("/goToRegisterForm")
    public String goToRegisterForm(Model model) {
        model.addAttribute("userRegisterForm", new UserRegisterForm());
        return "user/registerForm";
    }

    @GetMapping("/home")
    public String getHomePage() {
        return "home";
    }

}
