package pl.arturzaczek.exercise34.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.arturzaczek.exercise34.form.UserLoginForm;
import pl.arturzaczek.exercise34.form.UserRegisterForm;
import pl.arturzaczek.exercise34.services.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/registerUser")
    public String handleRegisterForm(
            @ModelAttribute @Valid UserRegisterForm userRegisterForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "user/registerForm";
        }
        userService.registerUser(userRegisterForm);
        return "redirect:/index";
    }
//    @PostMapping("/loginUser")
//    public String handleLoginForm(@ModelAttribute @Valid UserLoginForm userLoginForm, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            System.out.println("the form has errors");
//            return "user/loginForm";
//        }
//        if(userService.loginUser(userLoginForm)){
//            System.out.println("log in successful");
//            return "redirect:/index";
//        }
//        return "user/loginForm";
//    }
}
