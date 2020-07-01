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
    private final TeamRepository teamRepository;

    public ChildController(ChildRepository childRepository, StyleRepository styleRepository, LevelRepository levelRepository, ParentRepository parentRepository, SkillRepository skillRepository, UserRepository userRepository, TeamRepository teamRepository) {
        this.childRepository = childRepository;
        this.styleRepository = styleRepository;
        this.levelRepository = levelRepository;
        this.parentRepository = parentRepository;
        this.skillRepository = skillRepository;
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
    }

    @GetMapping(value = "/all")
    public String getAllChilds(Model model) {
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
    public String getEditChildForm(Model model, @PathVariable long id) throws Exception {
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

    @GetMapping("/styleTable/{id}")
    public String findAllByStyle(@PathVariable Long id, Model model) throws Exception {
        Optional<Style> styleOptional = styleRepository.findById(id);
        Style style = styleOptional.orElseThrow(Exception::new);
        List<Child> childList = childRepository.findByStyle(style);
        model.addAttribute("childStyle", childList);
        return "childStyle";
    }

    @GetMapping("/levelTAble/{id}")
    public String findAllChildsByLevel(@PathVariable Long id, Model model) throws Exception {
        Optional<Level> levelOptional = levelRepository.findById(id);
        Level level = levelOptional.orElseThrow(Exception::new);
        List<Child> childList = childRepository.findByLevel(level);
        model.addAttribute("childLevel" , childList);
        return "childLevel";
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

    @ModelAttribute("team")
    public List<Team> teamList() {
        return teamRepository.findAll();
    }


}
