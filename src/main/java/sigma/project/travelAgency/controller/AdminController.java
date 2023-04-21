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
public class AdminController {

    private UserServiceImpl userService;

    @ModelAttribute
    private void addUserDetails(Model model, Principal principal, Authentication authentication) {
        User user = userService.getUserByUsername(principal.getName());
        if (authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> "ROLE_ADMIN".equals(grantedAuthority.getAuthority()))) {
            model.addAttribute("users", userService.getAllUsers());
        }
        model.addAttribute("user", user);
    }

    @GetMapping("/admin")
    public String adminPanel(Model model){
        return "adminPanel";
    }

}
