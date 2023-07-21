package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.Bus;
import sigma.project.travelAgency.entity.Hotel;
import sigma.project.travelAgency.entity.Timetable;
import sigma.project.travelAgency.entity.Tour;

import java.util.List;

public interface TourService {

    Tour createTour (Tour tour, List<Timetable> timetable, Hotel hotel, Bus bus,String image);

    Tour createTourTest(Tour tour);
    void deleteById(Long id);

    List<Tour> findAll();

    boolean checkTour(String title);

    Tour getTourByTitle(String title);

    Tour getTourById(Long id);

    List<Tour> getByFlagFire();

}
