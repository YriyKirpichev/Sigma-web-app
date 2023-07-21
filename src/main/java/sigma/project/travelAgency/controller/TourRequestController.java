package sigma.project.travelAgency.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sigma.project.travelAgency.configuration.mail.EmailService;
import sigma.project.travelAgency.entity.Status;
import sigma.project.travelAgency.entity.Timetable;
import sigma.project.travelAgency.entity.Tour;
import sigma.project.travelAgency.entity.TourRequest;
import sigma.project.travelAgency.repository.StatusRepository;
import sigma.project.travelAgency.service.impl.*;
import sigma.project.travelAgency.util.auxiliaryClasses.WrappersClasses.TimetableWrapper;

import java.security.Principal;
import java.time.LocalDateTime;

@Slf4j
@Controller
@AllArgsConstructor
public class TourRequestController {

    private final UserServiceImpl userService;
    private final TourServiceImpl tourService;
    private final StatusServiceImpl statusService;
    private final TourRequestServiceImpl tourRequestService;
    private final StatusRepository statusRepository;

    private final BusTypeServiceImpl busTypeService;
    private final TimetableServiceImpl timetableService;
    private final EmailService emailService;

    @GetMapping("/user/select-option/{id}")
    public String selectOption(Model model, @PathVariable Long id){
        TourRequest tourRequest = tourRequestService.findById(id);
        TimetableWrapper timetableWrapper = new TimetableWrapper();
        timetableWrapper.addTimetable(new Timetable());
        model.addAttribute("tourRequest", tourRequest);
        model.addAttribute("tour",tourService.getTourById(tourRequest.getTour().getId()));
        model.addAttribute("timetable", new Timetable());
        int seatsCount = tourService.getTourById(tourRequest.getTour().getId()).getBusTypeSeatCount();

        busTypeService.generateSeatCod(seatsCount);

        model.addAttribute("seats" , busTypeService.generateSeatCod(seatsCount));
        return "newTourRequestPage";
    }

    @PostMapping("/user/select-option/{id}")
    public String saveSelectOption(Model model, @PathVariable Long id, @ModelAttribute("tourRequest") TourRequest tourRequest, @ModelAttribute("timetable") Timetable timetable, Principal principal){
        TourRequest tourRequestInBD = tourRequestService.findById(id);
        LocalDateTime dateNow = LocalDateTime.now();
        tourRequestInBD.setOrderDate(dateNow);
        tourRequestInBD.setStatus(statusRepository.findStatusByName("Заброньовано").stream()
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Tour request cannot be created")));
        tourRequestInBD.setBusPlease(tourRequest.getBusPlease());
        tourRequestInBD.setTimetable(timetableService.findById(timetable.getId()));
        tourRequestService.updateRequest(tourRequestInBD);
        Tour tour = tourService.getTourById(tourRequestInBD.getTour().getId());
        String recipientEmail = principal.getName();
        String subject = "Лист підтвердження про бронювання туру";
        String body = "Ви забронювали тур: \n" +
                "Назву туру: " + tour.getTitle()+ "\n" +
                "Ціна туру: " + tour.getCost()+ "\n" +
                "Дата виїзду: " + tour.getDepartureDate()+"\n" +
                "Дата прибуття у готель: " + tour.getDateArrivalAtHotel()+"\n" +
                "Дата виїзду з готелю:: " + tour.getDateCheckoutFromHotel()+"\n" +
                "Дата приїзду: " + tour.getArrivalDate();
        emailService.sendEmail(recipientEmail,subject,body);
        return "redirect:/catalog";
    }

    @PostMapping("/user/pre-select-option/{id}")
    public String savePreSelectOption(Model model, @PathVariable Long id,@ModelAttribute("tourRequest") TourRequest tourRequest, Principal principal){
        tourRequest.setUser(userService.getUserByUsername(principal.getName()));
        tourRequest.setTour(tourService.getTourById(id));
        tourRequestService.createRequest(tourRequest);
        Long idRequest = tourRequestService.findTourRequestByStatusIsNullAndUser(userService.getUserByUsername(principal.getName())).getId();
        return "redirect:/user/select-option/" + idRequest;
    }

    @GetMapping("/admin/tour-request/{id}")
    public String viewTourRequest(Model model, @PathVariable Long id) {

        model.addAttribute("statuses", statusService.getStatusByDestination("request"));
        model.addAttribute("request", tourRequestService.findById(id));
        model.addAttribute("statusSet", new Status());
        model.addAttribute("user", userService.getUserByUsername(tourRequestService.findById(id).getUser().getUsername()));
        TourRequest tourRequest = tourRequestService.findById(id);

        log.info(tourRequest.getTour().getId().toString());

        return "tourRequestPage";
    }

    @PostMapping("/admin/tour-request/{id}")
    public String setStatusRegister(Model model, @ModelAttribute("statusSet") Status status, @PathVariable Long id) {

        log.info("StatusSUS: " + status.getId());
        log.info("StatusSUS: " + status.getName());
        log.info("StatusSUS: " + status.getDestination());
        if(status.getId() != 0) {
            TourRequest tourRequest = tourRequestService.findById(id);
            tourRequest.setStatus(statusService.findById(status.getId()));
            tourRequestService.updateRequest(tourRequest);
        }
        return "redirect:/admin/tour-request/{id}";
    }

}
