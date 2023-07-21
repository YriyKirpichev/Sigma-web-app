package sigma.project.travelAgency.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sigma.project.travelAgency.entity.Tour;
import sigma.project.travelAgency.entity.User;
import sigma.project.travelAgency.service.imp.TourServiceImpl;
import sigma.project.travelAgency.service.imp.UserServiceImpl;
=======
import org.springframework.web.bind.annotation.*;

import sigma.project.travelAgency.entity.Tour;
import sigma.project.travelAgency.entity.User;
import sigma.project.travelAgency.service.impl.TourServiceImpl;
import sigma.project.travelAgency.service.impl.UserServiceImpl;
import sigma.project.travelAgency.util.auxiliaryClasses.Filtres.FilterByHotelType;
import sigma.project.travelAgency.util.auxiliaryClasses.Filtres.FilterByPeople;
import sigma.project.travelAgency.util.auxiliaryClasses.Filtres.FilterCost;
import sigma.project.travelAgency.util.auxiliaryClasses.Filtres.FilterListWrapper;
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22

import java.security.Principal;
import java.util.*;


@Slf4j
@Controller
@AllArgsConstructor
public class GeneralController {

<<<<<<< HEAD
    private UserServiceImpl userService;
    private TourServiceImpl tourService;
=======
    private final UserServiceImpl userService;
    private final TourServiceImpl tourService;
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22

    @ModelAttribute
    private void addUserDetails(Model model, Principal principal, Authentication authentication) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
    }

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
<<<<<<< HEAD
        Iterable<Tour> tour = tourService.findAll();
=======
        List<Tour> tour = tourService.getByFlagFire();
        FilterListWrapper filterListWrapper = new FilterListWrapper();
        filterListWrapper.addFilter("Збільшення ціни");
        filterListWrapper.addFilter("Зменшення ціни");
        filterListWrapper.addFilter("Типом готелю");
        filterListWrapper.addFilter("Кількість людей");

        model.addAttribute("tours", tour);
        model.addAttribute("filters", filterListWrapper);
        return "catalog";
    }

    @PostMapping("/catalog")
    public String catalogSort (Model model, @ModelAttribute("filters") FilterListWrapper filterListWrapper, HttpServletResponse response){
        log.info(filterListWrapper.getFilter().get(0));
        List<Tour> tour = tourService.getByFlagFire();
        FilterByPeople filterByPeople = new FilterByPeople();
        FilterByHotelType filterByHotelType = new FilterByHotelType();
        FilterCost filterCost = new FilterCost();

        if (filterListWrapper.getFilter().contains("Збільшення ціни")){
            tour.sort(filterCost.reversed());
        }
        if(filterListWrapper.getFilter().contains("Зменшення ціни")){
            tour.sort(filterCost);
        }
        if(filterListWrapper.getFilter().contains("Типом готелю")){
            tour.sort(filterByHotelType);
        }
        if(filterListWrapper.getFilter().contains("Кількість людей")){
            tour.sort(filterByPeople);
        }

        filterListWrapper.getFilter().clear();
        filterListWrapper.addFilter("Збільшення ціни");
        filterListWrapper.addFilter("Зменшення ціни");
        filterListWrapper.addFilter("Типом готелю");
        filterListWrapper.addFilter("Кількість людей");

        model.addAttribute("filters", filterListWrapper);
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
        model.addAttribute("tours", tour);
        return "catalog";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(value = "/create-user", consumes = MediaType.ALL_VALUE)
    public String createUser(@ModelAttribute("user") User user, HttpSession session) { //@RequestParam("image") MultipartFile file
        if (userService.checkUsername(user.getUsername())) {
            log.info("User with this email already exists");
            session.setAttribute("msg", String.format("Email '%s' already used", user.getUsername()));
        } else {
            try {
                userService.createUser(user,"ROLE_USER");
                session.setAttribute("msg", "Register successfully");
            } catch (Exception exception) {
                log.error("User creation failed", exception);
                session.setAttribute("msg", "Register failed");
            }
        }
        return "redirect:/register";
    }
}
