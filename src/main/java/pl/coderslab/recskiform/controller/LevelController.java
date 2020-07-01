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

    @RequestMapping("/fill")
    @ResponseBody
    public String populateWithLevel(){
//        for (int i= 1; i < 5; i++) {
//            Level level = new Level();
//            level.setLevelColor("color"+i);
//            level.setLevelDescription("opis poziomu zdobytego poziomu jako kolor"+i);
//            levelRepository.save(level);
//        }
        Level levelWhite = new Level();
        levelWhite.setLevelColor("Poziom bialy");
        levelWhite.setLevelDescription("Na tym poziomie Skrecamy Plugiem");
        levelRepository.save(levelWhite);

        Level levelGreen = new Level();
        levelGreen.setLevelColor("Poziom zielony");
        levelGreen.setLevelDescription("Na tym poziomie laczymy narty w momencie skretu");
        levelRepository.save(levelGreen);

        Level levelBlue = new Level();
        levelBlue.setLevelColor("Poziom niebieski");
        levelBlue.setLevelDescription("Na tym poziomie slizgamy sie rownolegle");
        levelRepository.save(levelBlue);

        Level levelRed = new Level();
        levelRed.setLevelColor("Poziom czerwony");
        levelRed.setLevelDescription("Na tym poziomie zaczynamy jezdzic na krawedziach");
        levelRepository.save(levelRed);

        Level levelBlack = new Level();
        levelBlack.setLevelColor("Poziom czarny");
        levelBlack.setLevelDescription("Na tym poziomie robimy dlugie i szybkie skrety");
        levelRepository.save(levelBlack);

        Level levelBrown = new Level();
        levelBrown.setLevelColor("Poziom brazowy");
        levelBrown.setLevelDescription("Na tym poziomie jedzimy krotkimi, cietymi skretami");
        levelRepository.save(levelBrown);

        Level levelSilver = new Level();
        levelSilver.setLevelColor("Poziom srebrny");
        levelSilver.setLevelDescription("Na tym poziomie potrafimy umiejetnie korzystac z pracy kijkow");
        levelRepository.save(levelSilver);

        Level levelGold = new Level();
        levelGold.setLevelColor("Poziom zloty");
        levelGold.setLevelDescription("Na tym poziomie jezdzimy sportowo");
        levelRepository.save(levelGold);

        String backLink = "<html><br><a href=\"/level/all\"> <<--- Powrot do listy Leveli </a></html>";
        return "dodano levele" + backLink;
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
