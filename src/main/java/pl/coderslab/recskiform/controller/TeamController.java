package pl.coderslab.recskiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.recskiform.entity.Child;
import pl.coderslab.recskiform.entity.Team;
import pl.coderslab.recskiform.repository.ChildRepository;
import pl.coderslab.recskiform.repository.TeamRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("team")
public class TeamController {

    private final TeamRepository teamRepository;
    private final ChildRepository childRepository;

    public TeamController(TeamRepository teamRepository, ChildRepository childRepository) {
        this.teamRepository = teamRepository;
        this.childRepository = childRepository;
    }

    @RequestMapping("/fill")
    @ResponseBody
    public String populateWithLevel(){
//        for (int i= 1; i < 5; i++) {
//            Team team = new Team();
//            team.setTeamName("abc");
//            team.setInstructor("abc");
//            teamRepository.save(team);
//        }
        Team teamWhite = new Team();
        teamWhite.setTeamName("Biali");
        teamWhite.setInstructor("Alexis Pinturault");
        teamRepository.save(teamWhite);

        Team teamGreen = new Team();
        teamGreen.setTeamName("Zieloni");
        teamGreen.setInstructor("Mikaela Shiffrin");
        teamRepository.save(teamGreen);

        Team teamBlue = new Team();
        teamBlue.setTeamName("Niebiescy");
        teamBlue.setInstructor("Marcel Hirsher");
        teamRepository.save(teamBlue);

        Team teamRed = new Team();
        teamRed.setTeamName("Czerwoni");
        teamRed.setInstructor("Wendy Holdener");
        teamRepository.save(teamRed);

        Team teamBlack = new Team();
        teamBlack.setTeamName("Czarni");
        teamBlack.setInstructor("Aksel Lund Svindal");
        teamRepository.save(teamBlack);

        Team teamBrown = new Team();
        teamBrown.setTeamName("Brazowi");
        teamBrown.setInstructor("Tina Maze");
        teamRepository.save(teamBrown);

        Team teamSilver = new Team();
        teamSilver.setTeamName("Srebrni");
        teamSilver.setInstructor("Bode Miller");
        teamRepository.save(teamSilver);

        Team teamGold = new Team();
        teamGold.setTeamName("Zloci");
        teamGold.setInstructor("Lindsey Vonn");
        teamRepository.save(teamGold);

        String backLink = "<html><br><a href=\"/team/all\"> <<--- Powrot do listy Teamow </a></html>";
        return "dodano teamy" + backLink;
    }



    @GetMapping(value = "/all")
    public String getAllTeams (Model model){
        List<Team> teamList = teamRepository.findAll();
        model.addAttribute("teams", teamList);
        return "teamList";
    }

    @RequestMapping(value = "addTeamForm", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("team", new Team());
        return "teamForm";
    }

    @RequestMapping(value = "addTeamForm", method = RequestMethod.POST)
    public String create(@Valid Team team, BindingResult result) {
        if (result.hasErrors()) {
            return "teamForm";
        }
       teamRepository.save(team);
        return "redirect:/team/all";
    }

    @RequestMapping(value = "editTeamForm/{id}", method = RequestMethod.GET)
    public String getEditTeamForm(Model model, @PathVariable long id) throws Exception{
        Optional<Team> byId = teamRepository.findById(id);
        Team team = byId.orElseThrow(Exception::new);
        model.addAttribute("team", team);
        return "teamEditForm";
    }

    @RequestMapping(value = "editTeamForm/{id}", method = RequestMethod.POST)
    public String update(@Valid Team team, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return "teamEditForm";
        }
        teamRepository.save(team);
        return "redirect:/team/all";
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public String deleteTeam(@PathVariable Long id) throws Exception {
        Optional<Team> byId = teamRepository.findById(id);
        Team team = byId.orElseThrow(Exception::new);
        teamRepository.delete(team);
        String backLink = "<html><br><a href=\"/team/all\"> <<--- Back to Teams List </a></html>";
        return "Skasowano Druzyne: " + team.getTeamName() + backLink;
    }

    @ModelAttribute("childs")
    public List<Child> childList() {
       return childRepository.findAll();
    }

}
