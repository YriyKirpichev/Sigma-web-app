package sigma.project.travelAgency.controller;

import jakarta.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
import sigma.project.travelAgency.entity.*;
import sigma.project.travelAgency.service.imp.*;
=======

import sigma.project.travelAgency.entity.User;
import sigma.project.travelAgency.entity.TourRequest;

import sigma.project.travelAgency.service.impl.UserServiceImpl;
import sigma.project.travelAgency.service.impl.TourRequestServiceImpl;
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping({"/admin"})
public class AdminController {

<<<<<<< HEAD
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
=======
    private final UserServiceImpl userService;
    private final TourRequestServiceImpl tourRequestService;
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22

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

<<<<<<< HEAD
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

=======
    @GetMapping("/delete-manager/{id}")
    public String deleteManager(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22

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
