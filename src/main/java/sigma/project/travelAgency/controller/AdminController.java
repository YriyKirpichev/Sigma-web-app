package sigma.project.travelAgency.controller;

import jakarta.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import sigma.project.travelAgency.entity.User;
import sigma.project.travelAgency.entity.TourRequest;

import sigma.project.travelAgency.service.impl.UserServiceImpl;
import sigma.project.travelAgency.service.impl.TourRequestServiceImpl;

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping({"/admin"})
public class AdminController {

    private final UserServiceImpl userService;
    private final TourRequestServiceImpl tourRequestService;

    @ModelAttribute
    private void addUserDetails(Model model, Principal principal) {

        User user = userService.getUserByUsername(principal.getName());
        List<TourRequest> tourRequestList = tourRequestService.getAllRequests();
        tourRequestList.sort(tourRequestService.reversed());
        List<User> managerList = userService.getByRoles("ROLE_MANAGER");

        model.addAttribute("tourRequests", tourRequestList);
        model.addAttribute("user", user);
        model.addAttribute("managers", managerList);

    }

    @GetMapping(value = "/")
    public String adminPanelURL_1(Model model) {
        return "adminPanel";
    }

    @GetMapping("")
    public String adminPanelURL_2(Model model) {
        return "adminPanel";
    }

    @GetMapping("/add-manager")
    public String addManager(Model model) {
        model.addAttribute("manager", new User());
        return "createManager";
    }

    @PostMapping(value = "/create-manager", consumes = MediaType.ALL_VALUE)
    public String createManager(@ModelAttribute("manager") User user, HttpSession session) {
        if (userService.checkUsername(user.getUsername())) {
            log.info("Manager with this email already exists");
            session.setAttribute("msg", String.format("Email '%s' already used", user.getUsername()));
        } else {
            try {
                userService.createUser(user, "ROLE_MANAGER");
                session.setAttribute("msg", "Register successfully");
            } catch (Exception exception) {
                log.error("User creation failed", exception);
                session.setAttribute("msg", "Register failed");
            }
        }
        return "redirect:/admin/add-manager";
    }

    @GetMapping("/delete-manager/{id}")
    public String deleteManager(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @PostMapping("/ban-user")
    public String banUser(Model model, @RequestParam("requestId") Long requestId, @RequestParam("userId") Long userId, @ModelAttribute("user") User user) {
        log.info(user.getBanDescription());
        userService.banUserById(userId);

        return "redirect:/admin/tour-request/" + requestId.intValue();
    }

    @GetMapping("/unban-user")
    public String unbanUser(Model model, @RequestParam("requestId") Long requestId, @RequestParam("userId") Long userId) {
        userService.unbanUserById(userId);
        return "redirect:/admin/tour-request/" + requestId.intValue();
    }

    @GetMapping("/clamp-request/{id}")
    public String clampRequest(@PathVariable Long id,Principal principal){
        TourRequest tourRequest = tourRequestService.findById(id);
        tourRequest.setResponsible(userService.getUserByUsername(principal.getName()));
        tourRequestService.updateRequest(tourRequest);
        return "redirect:/admin/";
    }

    @GetMapping("/unlink-request/{id}")
    public String unlinkRequest(@PathVariable Long id,Principal principal){
        TourRequest tourRequest = tourRequestService.findById(id);
        tourRequest.setResponsible(null);
        tourRequestService.updateRequest(tourRequest);
        return "redirect:/admin/";
    }


}
