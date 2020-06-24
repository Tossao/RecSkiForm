package pl.coderslab.recskiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.recskiform.entity.Style;
import pl.coderslab.recskiform.repository.StyleRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("style")
public class StyleController {

    private final StyleRepository styleRepository;

    public StyleController(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @GetMapping(value = "/all")
    public String getAllStyles (Model model){
        List<Style> styleList = styleRepository.findAll();
        model.addAttribute("styles", styleList);
        return "styleList";
    }

    @RequestMapping(value = "addStyleForm", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("style", new Style());
        return "styleForm";
    }

    @RequestMapping(value = "addStyleForm", method = RequestMethod.POST)
    public String create(@Valid Style style, BindingResult result) {
        if (result.hasErrors()) {
            return "styleForm";
        }
        styleRepository.save(style);
        return "redirect:/style/all";
    }

    @RequestMapping(value = "editStyleForm/{id}", method = RequestMethod.GET)
    public String getEditStyleForm(Model model, @PathVariable long id) throws Exception{
        Optional<Style> byId = styleRepository.findById(id);
        Style style = byId.orElseThrow(Exception::new);
        model.addAttribute("style", style);
        return "styleEditForm";
    }

    @RequestMapping(value = "editStyleForm/{id}", method = RequestMethod.POST)
    public String update(@Valid Style style, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return "styleEditForm";
        }
        styleRepository.save(style);
        return "redirect:/style/all";
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public String deleteStyle(@PathVariable Long id) throws Exception {
        Optional<Style> byId = styleRepository.findById(id);
        Style style = byId.orElseThrow(Exception::new);
        styleRepository.delete(style);
        String backLink = "<html><br><a href=\"/style/all\"> <<--- Back to Styles List </a></html>";
        return "Skasowano Styl: " + style.getStyleName() + backLink;
    }
}
