package pl.coderslab.recskiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.recskiform.entity.User;
import pl.coderslab.recskiform.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/all")
    public String getAllParents (Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("users", userList);
        return "userList";
    }


}

