package pl.coderslab.recskiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.recskiform.entity.Level;
import pl.coderslab.recskiform.repository.LevelRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("level")
public class LevelController {

    private final LevelRepository levelRepository;

    public LevelController(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @RequestMapping("/populate")
    @ResponseBody
    public String populateWithLevel(){
        for (int i= 1; i < 5; i++) {
            Level level = new Level();
            level.setLevelColor("color"+i);
            level.setLevelDescription("opis poziomu zdobytego poziomu jako kolor"+i);
            levelRepository.save(level);
        }
        return "dodano testowe levele";
    }

    @GetMapping(value = "/all")
    public String getAllLevels (Model model){
        List<Level> levelList = levelRepository.findAll();
        model.addAttribute("levels", levelList);
        return "levelList";
    }

    @RequestMapping(value = "addLevelForm", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("level", new Level());
        return "levelForm";
    }

    @RequestMapping(value = "addLevelForm", method = RequestMethod.POST)
    public String create(@Valid Level level, BindingResult result) {
        if (result.hasErrors()) {
            return "levelForm";
        }
        levelRepository.save(level);
        return "redirect:/level/all";
    }

    @RequestMapping(value = "editLevelForm/{id}", method = RequestMethod.GET)
    public String getEditLevelForm(Model model, @PathVariable long id) throws Exception{
        Optional<Level> byId = levelRepository.findById(id);
        Level level = byId.orElseThrow(Exception::new);
        model.addAttribute("level", level);
        return "levelEditForm";
    }

    @RequestMapping(value = "editLevelForm/{id}", method = RequestMethod.POST)
    public String update(@Valid Level level, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return "levelEditForm";
        }
        levelRepository.save(level);
        return "redirect:/level/all";
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public String deleteLevel(@PathVariable Long id) throws Exception {
        Optional<Level> byId = levelRepository.findById(id);
        Level level = byId.orElseThrow(Exception::new);
        levelRepository.delete(level);
        String backLink = "<html><br><a href=\"/level/all\"> <<--- Back to Levels List </a></html>";
        return "Skasowano Poziom: " + level.getLevelColor() + backLink;
    }

}
