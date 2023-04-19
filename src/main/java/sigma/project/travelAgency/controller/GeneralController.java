package sigma.project.travelAgency.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class GeneralController {

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "This page about us");
        return "about";
    }

    @GetMapping("/catalog")
    public String catalog (Model model){
        //Iterable<Tour> tour = tourService.getAllTour();
       // model.addAttribute("tours", tour);
        return "catalog";
    }



}
