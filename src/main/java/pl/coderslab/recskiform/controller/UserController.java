package pl.coderslab.recskiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.recskiform.entity.User;
import pl.coderslab.recskiform.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "addUserForm", method = RequestMethod.GET)
    public String getForm(Model model) {
    model.addAttribute("user", new User());
    return "userForm";
    }

    @RequestMapping(value = "addUserForm", method = RequestMethod.POST)
    public String create(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "userForm";
        }
        userRepository.save(user);
        return "redirect:/user/all";
    }

    @RequestMapping(value = "editUserForm/{id}", method = RequestMethod.GET)
    public String getEditUserForm(Model model, @PathVariable long id) throws Exception{
        Optional<User> byId = userRepository.findById(id);
        User user = byId.orElseThrow(Exception::new);
        model.addAttribute("user", user);
        return "userEditForm";
    }

    @RequestMapping(value = "editUserForm/{id}", method = RequestMethod.POST)
    public String update(@Valid User user, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return "userEditForm";
        }
        userRepository.save(user);
        return "redirect:/user/all";
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable Long id) throws Exception {
        Optional<User> byId = userRepository.findById(id);
        User user = byId.orElseThrow(Exception::new);
        userRepository.delete(user);
        String backLink = "<html><br><a href=\"/user/all\"> <<--- Back to Users List </a></html>";
        return "Skasowano Usera: " + user.getLogin() + backLink;
    }


}

