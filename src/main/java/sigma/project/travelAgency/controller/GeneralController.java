package sigma.project.travelAgency.controller;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sigma.project.travelAgency.entity.Tour;
import sigma.project.travelAgency.entity.User;
import sigma.project.travelAgency.service.impl.TourServiceImpl;
import sigma.project.travelAgency.service.impl.UserServiceImpl;

import java.security.Principal;


@Slf4j
@Controller
@AllArgsConstructor
public class GeneralController {

    private UserServiceImpl userService;
    private TourServiceImpl tourService;

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
        Iterable<Tour> tour = tourService.findAll();
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
//                String filename = UUIDHelper.random();
//                user.setImageId(filename);
                userService.createUser(user,"ROLE_USER");
//                fileService.uploadFile(filename, user.getEmail(), file);
                session.setAttribute("msg", "Register successfully");
            } catch (Exception exception) {
                log.error("User creation failed", exception);
                session.setAttribute("msg", "Register failed");
            }
        }
        return "redirect:/register";
    }

}
