package sigma.project.travelAgency.controller;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sigma.project.travelAgency.entity.*;
import sigma.project.travelAgency.service.impl.*;

import java.security.Principal;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private UserServiceImpl userService;
    private BusServiceImpl busService;
    private BusTypeServiceImpl busTypeService;
    private CompanionServiceImpl companionService;
    private FeatureServiceImpl featureService;
    private HotelClassServiceImpl hotelClassService;
    private HotelServiceImpl hotelService;
    private RoomServiceImpl roomService;
    private TimetableServiceImpl timetableService;
    private TourServiceImpl tourService;

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

    @GetMapping("/add-tour")
    public String addTour(Model model){
        model.addAttribute("tour",new Tour());
        model.addAttribute("busType",new BusType());
        model.addAttribute("bus", new Bus());
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("hotelClass", new HotelClass());
        model.addAttribute("room", new Room());
        model.addAttribute("features", new Feature());
        model.addAttribute("companion", new Companion());
        model.addAttribute("timetable", new Timetable());
        return "create-tour";
    }

    @PostMapping(value = "/create-tour", consumes = MediaType.ALL_VALUE) //@RequestParam("image") MultipartFile file
    public String createTour(Model model, HttpSession httpSession,
                             @ModelAttribute("tour") Tour tour,                     @ModelAttribute("busType") BusType busType,
                             @ModelAttribute("bus") Bus bus,                        @ModelAttribute("hotel") Hotel hotel,
                             @ModelAttribute("hotelClass") HotelClass hotelClass,   @ModelAttribute("room") Room room,
                             @ModelAttribute("features") Feature features,          @ModelAttribute("companion") Companion companion,
                             @ModelAttribute("timetable") Timetable timetable){

        busTypeService.createBusType(busType);
        busService.createBus(bus,busType);

        roomService.createRoom(room);
        featureService.create(features);
        companionService.create(companion);
        hotelClassService.createClass(hotelClass);

        hotelService.createHotel(hotel,room,features,companion,hotelClass);

        timetableService.create(timetable);

        tourService.createTour(tour,timetable,hotel,bus);

        return "redirect:/admin/add-tour";
    }

    @GetMapping ("/delete-tour/{id}")
    public String deleteTour (@PathVariable Long id){
        tourService.deleteTour(id);
        return "redirect:/catalog";
    }




}
