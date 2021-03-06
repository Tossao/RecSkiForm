package pl.coderslab.recskiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.recskiform.entity.Child;
import pl.coderslab.recskiform.repository.ChildRepository;
import pl.coderslab.recskiform.repository.LevelRepository;
import pl.coderslab.recskiform.repository.StyleRepository;

import java.util.List;

@Controller
public class IndexController {

    private final ChildRepository childRepository;
    private final StyleRepository styleRepository;
    private final LevelRepository levelRepository;

    public IndexController(ChildRepository childRepository, StyleRepository styleRepository, LevelRepository levelRepository) {
        this.childRepository = childRepository;
        this.styleRepository = styleRepository;
        this.levelRepository = levelRepository;
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<Child> childIndexList =childRepository.findFirst5ByOrderByIdDesc();
        model.addAttribute("childIndexList", childIndexList);
        model.addAttribute("style", styleRepository.findAll());
        model.addAttribute("level", levelRepository.findAll());

        return "index";
    }



    @GetMapping("/about")
    @ResponseBody
    public String about() {
        return "Here you can find some details for logged users";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "Here you can find some details for logged ADMIN";
    }



}
