package pl.coderslab.recskiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.recskiform.entity.*;
import pl.coderslab.recskiform.repository.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("child")
public class ChildController {

    private final ChildRepository childRepository;
    private final StyleRepository styleRepository;
    private final LevelRepository levelRepository;
    private final ParentRepository parentRepository;
    private final SkillRepository skillRepository;
    private final UserRepository userRepository;

    public ChildController(ChildRepository childRepository, StyleRepository styleRepository, LevelRepository levelRepository, ParentRepository parentRepository, SkillRepository skillRepository, UserRepository userRepository) {
        this.childRepository = childRepository;
        this.styleRepository = styleRepository;
        this.levelRepository = levelRepository;
        this.parentRepository = parentRepository;
        this.skillRepository = skillRepository;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/all")
    public String getAllChilds (Model model){
        List<Child> childList = childRepository.findAll();
        model.addAttribute("childs", childList);
        return "childList";
    }

    @RequestMapping(value = "addChildForm", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("child", new Child());
        return "childForm";
    }

    @RequestMapping(value = "addChildForm", method = RequestMethod.POST)
    public String create(@Valid Child child, BindingResult result) {
        if (result.hasErrors()) {
            return "childForm";
        }
        childRepository.save(child);
        return "redirect:/child/all";
    }

    @RequestMapping(value = "editChildForm/{id}", method = RequestMethod.GET)
    public String getEditChildForm(Model model, @PathVariable long id) throws Exception{
        Optional<Child> byId = childRepository.findById(id);
        Child child = byId.orElseThrow(Exception::new);
        model.addAttribute("child", child);
        return "childEditForm";
    }

    @RequestMapping(value = "editChildForm/{id}", method = RequestMethod.POST)
    public String update(@Valid Child child, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return "childEditForm";
        }
        childRepository.save(child);
        return "redirect:/child/all";
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public String deleteChild(@PathVariable Long id) throws Exception {
        Optional<Child> byId = childRepository.findById(id);
        Child child = byId.orElseThrow(Exception::new);
        childRepository.delete(child);
        String backLink = "<html><br><a href=\"/child/all\"> <<--- Back to Childs List </a></html>";
        return "Skasowano Dziecko: " + child.getLastName() + " " + child.getFirstName() + backLink;
    }

    @ModelAttribute("style")
    public List<Style> styleList() {
        return styleRepository.findAll();
    }

    @ModelAttribute("level")
    public List<Level> levelList() {
        return levelRepository.findAll();
    }

    @ModelAttribute("parent")
    public List<Parent> parentList() {
        return parentRepository.findAll();
    }

    @ModelAttribute("skill")
    public List<Skill> skillList() {
        return skillRepository.findAll();
    }

    @ModelAttribute("user")
    public List<User> userList() {
        return userRepository.findAll();
    }





}
