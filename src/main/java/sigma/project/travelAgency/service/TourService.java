package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.Bus;
import sigma.project.travelAgency.entity.Hotel;
import sigma.project.travelAgency.entity.Timetable;
import sigma.project.travelAgency.entity.Tour;

import java.util.List;
import java.util.Optional;

public interface TourService {

    Tour createTour (Tour tour, Timetable timetable, Hotel hotel, Bus bus);

    void deleteTour(Long id);

    List<Tour> findAll();

    boolean checkTour(String title);

    Tour getTourByTitle(String title);

}
