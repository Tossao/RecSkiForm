package pl.coderslab.recskiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.recskiform.entity.Parent;
import pl.coderslab.recskiform.repository.ParentRepository;

import java.util.List;

@Controller
@RequestMapping("parent")
public class ParentController {

    private final ParentRepository parentRepository;

    public ParentController(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @GetMapping(value = "/all")
    public String getAllParents (Model model){
        List<Parent> parentList = parentRepository.findAll();
        model.addAttribute("parents", parentList);
        return "parentList";

    }

}
