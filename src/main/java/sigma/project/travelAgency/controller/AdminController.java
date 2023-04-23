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
import org.springframework.web.bind.annotation.RequestMapping;
import sigma.project.travelAgency.entity.User;
import sigma.project.travelAgency.service.imp.UserServiceImpl;

import java.security.Principal;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private UserServiceImpl userService;

    @ModelAttribute
    private void addUserDetails(Model model, Principal principal, Authentication authentication) {
        User user = userService.getUserByUsername(principal.getName());
//        if (authentication.getAuthorities().stream()
//                .anyMatch(grantedAuthority -> "ROLE_ADMIN".equals(grantedAuthority.getAuthority()))) {
//            model.addAttribute("managers", userService.getAllUsers());
//        }
        model.addAttribute("user", user);
    }

    @GetMapping("/")
    public String adminPanel(Model model){
        return "adminPanel";
    }

    @GetMapping("/add-manager")
    public String addManager(Model model){
        model.addAttribute("manager", new User());
        return "createManager";
    }

    @PostMapping(value = "/create-manager", consumes = MediaType.ALL_VALUE)
    public String createManager(@ModelAttribute("manager") User user, HttpSession session) { //@RequestParam("image") MultipartFile file
        if (userService.checkUsername(user.getUsername())) {
            log.info("Manager with this email already exists");
            session.setAttribute("msg", String.format("Email '%s' already used", user.getUsername()));
        } else {
            try {
//                String filename = UUIDHelper.random();
//                user.setImageId(filename);
                userService.createUser(user,"ROLE_MANAGER");
//                fileService.uploadFile(filename, user.getEmail(), file);
                session.setAttribute("msg", "Register successfully");
            } catch (Exception exception) {
                log.error("User creation failed", exception);
                session.setAttribute("msg", "Register failed");
            }
        }
        return "redirect:/admin/add-manager";
    }




}
