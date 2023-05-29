package sigma.project.travelAgency.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import sigma.project.travelAgency.entity.Tour;
import sigma.project.travelAgency.entity.BusType;
import sigma.project.travelAgency.entity.Bus;
import sigma.project.travelAgency.entity.Hotel;
import sigma.project.travelAgency.entity.HotelClass;
import sigma.project.travelAgency.entity.Room;
import sigma.project.travelAgency.entity.Feature;
import sigma.project.travelAgency.entity.Companion;
import sigma.project.travelAgency.entity.Timetable;
import sigma.project.travelAgency.entity.TourRequest;

import sigma.project.travelAgency.service.impl.*;
import sigma.project.travelAgency.util.auxiliaryClasses.WrappersClasses.*;
import sigma.project.travelAgency.util.files.S3Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@AllArgsConstructor
public class TourController {
    private final BusServiceImpl busService;
    private final BusTypeServiceImpl busTypeService;
    private final CompanionServiceImpl companionService;
    private final FeatureServiceImpl featureService;
    private final HotelClassServiceImpl hotelClassService;
    private final HotelServiceImpl hotelService;
    private final RoomServiceImpl roomService;
    private final TimetableServiceImpl timetableService;
    private final TourServiceImpl tourService;
    private final TourRequestServiceImpl tourRequestService;
    private final S3Service s3Service;

    @ModelAttribute
    private void addTourRequestList(Model model) {
        List<TourRequest> tourRequestList = tourRequestService.getAllRequests();
        model.addAttribute("tourRequests", tourRequestList);
    }

    @GetMapping(value = "/tour/{id}")
    public String tourView(Model model,@PathVariable Long id){

        Tour tour = tourService.getTourById(id);
        model.addAttribute("tour",tour);
        model.addAttribute("tourRequest", new TourRequest());
        return "tourPage";
    }


    @GetMapping("/admin/add-tour")
    public String addTour(Model model) {

        FeatureWrapper featureWrapper = new FeatureWrapper();
        RoomWrapper roomWrapper = new RoomWrapper();
        BusWrapper busWrapper = new BusWrapper();
        BusTypeWrapper busTypeWrapper = new BusTypeWrapper();
        TimetableWrapper timetableWrapper = new TimetableWrapper();
        busTypeWrapper.setBusTypeList(busTypeService.getAllBusType());

        for (int i = 1; i <= 4; i++) {
            featureWrapper.addFeatures(new Feature());
            roomWrapper.addRoom(new Room());
            busWrapper.addBus(new Bus());
        }
        for (int i = 1; i <= 9; i++) {
            timetableWrapper.addTimetable(new Timetable());
        }

        model.addAttribute("tour", new Tour());
        model.addAttribute("busType", new BusType());
        model.addAttribute("bus", new Bus());
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("hotelClass", new HotelClass());
        model.addAttribute("room", roomWrapper);
        model.addAttribute("features", featureWrapper);
        model.addAttribute("companion", new Companion());
        model.addAttribute("timetable", timetableWrapper);
        return "create-tour";
    }

    @PostMapping(value = "/admin/create-tour", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String createTour(Model model, @RequestParam("file") MultipartFile file,
                             @ModelAttribute("tour") Tour tour,
                             @ModelAttribute("busType") BusType busType,
                             @ModelAttribute("bus") Bus buses,
                             @ModelAttribute("hotel") Hotel hotel,
                             @ModelAttribute("hotelClass") HotelClass hotelClass,
                             @ModelAttribute("room") RoomWrapper rooms,
                             @ModelAttribute("features") FeatureWrapper features,
                             @ModelAttribute("companion") Companion companion,
                             @ModelAttribute("timetable") TimetableWrapper timetables) {

        busTypeService.createBusType(busType);
        busService.createBus(buses, busType);

        roomService.createRoom(rooms.getRoomList());

        featureService.create(features.getFeatureList());
        companionService.create(companion);
        hotelClassService.createClass(hotelClass);

        hotelService.createHotel(hotel, rooms.getRoomList(), features.getFeatureList(), companion, hotelClass);

        timetableService.create(timetables.getTimetableList());

        String image = UUID.randomUUID().toString();

        s3Service.uploadImage(image, file);

        tourService.createTour(tour, timetables.getTimetableList(), hotel, buses, image);

        return "create-tour";
    }

    @GetMapping("/admin/delete-tour/{id}")
    public String deleteTour(@PathVariable Long id) {
        busService.deleteById(tourService.getTourById(id).getBus().iterator().next().getId());
        hotelService.deleteById(tourService.getTourById(id).getHotel().getId());
        timetableService.deleteById(tourService.getTourById(id).getTimetable().iterator().next().getId());
        return "redirect:/catalog";
    }


}
