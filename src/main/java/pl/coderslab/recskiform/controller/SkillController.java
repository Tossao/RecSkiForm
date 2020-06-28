package pl.coderslab.recskiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.recskiform.entity.Skill;
import pl.coderslab.recskiform.repository.SkillRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("skill")
public class SkillController {

    private final SkillRepository skillRepository;

    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @RequestMapping("/populate")
    @ResponseBody
    public String populateWithSkills(){
        for (int i= 1; i < 8; i++) {
            Skill skill = new Skill();
            skill.setSkillName("skill"+i);
            skill.setSkillDescription("opis skilla posiadanej umiejetnosci"+i);
            skillRepository.save(skill);
        }
        return "dodano testowe skille";
    }

    @GetMapping(value = "/all")
    public String getAllSkills (Model model){
        List<Skill> skillList = skillRepository.findAll();
        model.addAttribute("skills", skillList);
        return "skillList";
    }

    @RequestMapping(value = "addSkillForm", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("skill", new Skill());
        return "skillForm";
    }

    @RequestMapping(value = "addSkillForm", method = RequestMethod.POST)
    public String create(@Valid Skill skill, BindingResult result) {
        if (result.hasErrors()) {
            return "skillForm";
        }
        skillRepository.save(skill);
        return "redirect:/skill/all";
    }

    @RequestMapping(value = "editSkillForm/{id}", method = RequestMethod.GET)
    public String getEditSkillForm(Model model, @PathVariable long id) throws Exception{
        Optional<Skill> byId = skillRepository.findById(id);
        Skill skill = byId.orElseThrow(Exception::new);
        model.addAttribute("skill", skill);
        return "skillEditForm";
    }

    @RequestMapping(value = "editSkillForm/{id}", method = RequestMethod.POST)
    public String update(@Valid Skill skill, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return "skillEditForm";
        }
        skillRepository.save(skill);
        return "redirect:/skill/all";
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public String deleteSkill(@PathVariable Long id) throws Exception {
        Optional<Skill> byId = skillRepository.findById(id);
        Skill skill = byId.orElseThrow(Exception::new);
        skillRepository.delete(skill);
        String backLink = "<html><br><a href=\"/skill/all\"> <<--- Back to Skills List </a></html>";
        return "Skasowano Skilla: " + skill.getSkillName() + backLink;
    }


}
