package sigma.project.travelAgency.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import sigma.project.travelAgency.entity.TourRequest;
import sigma.project.travelAgency.entity.User;
import sigma.project.travelAgency.service.impl.*;

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;
    private final TourRequestServiceImpl tourRequestService;


    @ModelAttribute
    private void addUserDetails(Model model, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        List<TourRequest> tourRequestList = tourRequestService.findByUser(userService.getUserByUsername(principal.getName()));
        model.addAttribute("user", user);
        model.addAttribute("tourRequests", tourRequestList);
    }

    @GetMapping("/")
    public String userAccount(Model model){
        return "userAccount";
    }
}
