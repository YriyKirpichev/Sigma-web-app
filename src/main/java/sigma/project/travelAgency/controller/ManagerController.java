package sigma.project.travelAgency.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import sigma.project.travelAgency.entity.User;
import sigma.project.travelAgency.service.imp.UserServiceImpl;

import java.security.Principal;

@Slf4j
@Controller
@AllArgsConstructor
public class ManagerController {

    private UserServiceImpl userService;

    @ModelAttribute
    private void addUserDetails(Model model, Principal principal, Authentication authentication) {
        User user = userService.getUserByUsername(principal.getName());
        if (authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> "ROLE_MANAGER".equals(grantedAuthority.getAuthority()))) {
            model.addAttribute("users", userService.getAllUsers());
        }
        model.addAttribute("user", user);
    }

    @GetMapping("/manager")
    public String managerPanel(Model model){
        return "/managerPanel";
    }



}
