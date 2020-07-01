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

    @RequestMapping("/fill")
    @ResponseBody
    public String populateWithSkills(){
//        for (int i= 1; i < 8; i++) {
//            Skill skill = new Skill();
//            skill.setSkillName("skill"+i);
//            skill.setSkillDescription("opis skilla posiadanej umiejetnosci"+i);
//            skillRepository.save(skill);
//        }
        Skill skill1 = new Skill();
        skill1.setSkillName("samodzielna jazda orczykiem");
        skill1.setSkillDescription("Dziecko potrafi samodzielnie zlapac orczyk i wjechac nim na gore stoku bez wywrotki");
        skillRepository.save(skill1);

        Skill skill2 = new Skill();
        skill2.setSkillName("samodzielna jazda krzeselkiem");
        skill2.setSkillDescription("Dziecko potrafi samodzielnie wsiasc na krzeselko i zniego zsiasc");
        skillRepository.save(skill2);

        Skill skill3 = new Skill();
        skill3.setSkillName("jazda plugiem");
        skill3.setSkillDescription("Dziecko potrafi zjecach w dol stoku lukami pluznymi kontrolujac predkosc");
        skillRepository.save(skill3);

        Skill skill4 = new Skill();
        skill4.setSkillName("skret rownolegly dlugi");
        skill4.setSkillDescription("Dziecko potrafi wykonac dlugi skret prowadzac narty rownolegle i trzymajac je na krawedzi wykorzystujac cala szerokosc stoku");
        skillRepository.save(skill4);

        Skill skill5 = new Skill();
        skill5.setSkillName("skret rownolegly krotki ");
        skill5.setSkillDescription("Dziecko potrafi wykonywac krotkie skrety szybko zmieniajac krawedz prowadzac narty rownolegle");
        skillRepository.save(skill5);

        Skill skill6 = new Skill();
        skill6.setSkillName("smig");
        skill6.setSkillDescription("Dziecko potrafi zjechac w dol stoku wykonujac serie szybkich, krotkich skretow rownoleglych ze stałą predkością");
        skillRepository.save(skill6);

        String backLink = "<html><br><a href=\"/skill/all\"> <<--- Powrot do listy Umiejetnosci </a></html>";
        return "dodano skille" +backLink;
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
