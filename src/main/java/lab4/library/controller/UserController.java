package lab4.library.controller;

import lab4.library.service.UserServiceImpl;
import lab4.library.user.User;
import lab4.library.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserValidator userValidator;

    @InitBinder
    protected void initBuinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @GetMapping(value = "/registrationform")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "user/registration";
    }

    /*@PostMapping(value = "/registeruser")
    public String registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String confirmPassword, Model model) {

        if (password.compareTo(confirmPassword) != 0) {
            model.addAttribute("error", "Passwords are different!");
            return "user/registration";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userService.singupUser(user);

        model.addAttribute("registrationMessage", "You have successfully registered, now sign in to your account");

        return "startpage";
    }*/

    @PostMapping(value = "/registeruser")
    public String registerUser(@ModelAttribute(name = "user") @Valid User user, BindingResult bindingResult, @RequestParam String confirmPassword, Model model) {

        if (bindingResult.hasErrors()) {
            return "user/registration";
        }

        if (user.getPassword().compareTo(confirmPassword) != 0) {
            model.addAttribute("error", "Passwords are different!");
            return "user/registration";
        }

        userService.singupUser(user);

        model.addAttribute("registrationMessage", "You have successfully registered, now sign in to your account");

        return "startpage";
    }

    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout) {

        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }

        if (logout != null) {
            model.addAttribute("logout", "You have been successfully logged out.");
        }
        return "user/login";
    }
}
