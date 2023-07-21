package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.Bus;
import sigma.project.travelAgency.entity.Hotel;
import sigma.project.travelAgency.entity.Timetable;
import sigma.project.travelAgency.entity.Tour;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;

public interface TourService {

    Tour createTour (Tour tour, Timetable timetable, Hotel hotel, Bus bus);

    void deleteTour(Long id);
=======

public interface TourService {

    Tour createTour (Tour tour, List<Timetable> timetable, Hotel hotel, Bus bus,String image);

    Tour createTourTest(Tour tour);
    void deleteById(Long id);
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22

    List<Tour> findAll();

    boolean checkTour(String title);

    Tour getTourByTitle(String title);

<<<<<<< HEAD
=======
    Tour getTourById(Long id);

    List<Tour> getByFlagFire();

>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
}
