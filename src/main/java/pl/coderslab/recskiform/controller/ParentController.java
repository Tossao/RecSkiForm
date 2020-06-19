package pl.coderslab.recskiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.recskiform.entity.Parent;
import pl.coderslab.recskiform.entity.User;
import pl.coderslab.recskiform.repository.ParentRepository;
import pl.coderslab.recskiform.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("parent")
public class ParentController {

    private final ParentRepository parentRepository;
    private final UserRepository userRepository;

    public ParentController(ParentRepository parentRepository, UserRepository userRepository) {
        this.parentRepository = parentRepository;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/all")
    public String getAllParents (Model model){
        List<Parent> parentList = parentRepository.findAll();
        model.addAttribute("parents", parentList);
        return "parentList";
    }

    @RequestMapping(value = "addParentForm", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("parent", new Parent());
        return "parentForm";
    }

    @RequestMapping(value = "addParentForm", method = RequestMethod.POST)
    public String create(@Valid Parent parent, BindingResult result) {
        if (result.hasErrors()) {
            return "parentForm";
        }
        parentRepository.save(parent);
        return "redirect:/parent/all";
    }

    @RequestMapping(value = "editParentForm/{id}", method = RequestMethod.GET)
    public String getEditParentForm(Model model, @PathVariable long id) throws Exception{
        Optional<Parent> byId = parentRepository.findById(id);
        Parent parent = byId.orElseThrow(Exception::new);
        model.addAttribute("parent", parent);
        return "parentEditForm";
    }

    @RequestMapping(value = "editParentForm/{id}", method = RequestMethod.POST)
    public String update(@Valid Parent parent, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return "parentEditForm";
        }
        parentRepository.save(parent);
        return "redirect:/parent/all";
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public String deleteParent(@PathVariable Long id) throws Exception {
        Optional<Parent> byId = parentRepository.findById(id);
        Parent parent = byId.orElseThrow(Exception::new);
        parentRepository.delete(parent);
        String backLink = "<html><br><a href=\"/parent/all\"> <<--- Back to Parents List </a></html>";
        return "Skasowano Rodzica: " + parent.getLastName() + " " + parent.getLastName() + backLink;
    }

    @ModelAttribute("user")
    public List<User> userList() {
        return userRepository.findAll();
    }

}
