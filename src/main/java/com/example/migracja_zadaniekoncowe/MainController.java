package com.example.migracja_zadaniekoncowe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    String home(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "home";
    }

    @GetMapping("/add-user")
    String addUser(Model model) {
        model.addAttribute("newUser", new User());
        return "addUserPage";
    }

    @PostMapping("/add-user")
    String addUser(User user){
        userRepository.save(user);
        return "redirect:/";
    }
}
