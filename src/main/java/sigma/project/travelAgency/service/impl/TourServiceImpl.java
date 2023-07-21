<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/TourServiceImpl.java
package sigma.project.travelAgency.service.imp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
=======
package sigma.project.travelAgency.service.impl;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/TourServiceImpl.java
import sigma.project.travelAgency.entity.*;
import sigma.project.travelAgency.repository.StatusRepository;
import sigma.project.travelAgency.repository.TourRepository;
import sigma.project.travelAgency.service.TourService;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/TourServiceImpl.java
import java.util.Optional;
=======
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/TourServiceImpl.java

@Slf4j
@Service
@AllArgsConstructor
public class TourServiceImpl implements TourService {

    private TourRepository tourRepository;
    private StatusRepository statusRepository;

<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/TourServiceImpl.java
    @Override
    public Tour createTour(Tour tour, Timetable timetable, Hotel hotel, Bus bus) {
=======
    private EntityManager entityManager;

    @Override
    public Tour createTour(Tour tour, List<Timetable> timetables, Hotel hotel, Bus bus,String image) {
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/TourServiceImpl.java
        log.info("Create Tour: '{}'", tour.getTitle());

        List<Bus> buses = new ArrayList<>();
        buses.add(bus);
        tour.setBus(buses);

        tour.setHotel(hotel);

<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/TourServiceImpl.java
        List<Timetable> timetables = new ArrayList<>();
        timetables.add(timetable);
=======
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/TourServiceImpl.java
        tour.setTimetable(timetables);

        Status status = statusRepository.findStatusByName("Доступно").stream()
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Tour cannot be created"));

        tour.setStatus(status);

<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/TourServiceImpl.java
=======
        tour.setImage(image);

>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/TourServiceImpl.java
        return tourRepository.save(tour);
    }

    @Override
<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/TourServiceImpl.java
    public void deleteTour(Long id) {
        log.info("Delete Tour by id: '{}'", id);
        tourRepository.deleteById(id);
=======
    public Tour createTourTest(Tour tour) {
        return tourRepository.save(tour);
    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Delete Tour by id: '{}'", id);
        Tour managedTour = entityManager.merge(tourRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Timetable doesn't exists")));
        entityManager.remove(managedTour);
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/TourServiceImpl.java
    }

    @Override
    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    @Override
    public boolean checkTour(String title) {
        log.info("Check if Tour with title: '{}' exists", title);
        return tourRepository.existsByTitle(title);
    }

    @Override
    public Tour getTourByTitle(String title) {
        log.info("Searching Tour by title: '{}'", title);
        return tourRepository.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("Tour doesn't exists"));
    }

<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/TourServiceImpl.java
=======
    @Override
    public Tour getTourById(Long id){
        log.info("Searching Tour by title: '{}'", id);
        return tourRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tour doesn't exists"));
    }

    @Override
    public List<Tour> getByFlagFire(){
        List<Tour> tours = tourRepository.findToursByFlagFireIsTrue();
        tours.addAll(tourRepository.findToursByFlagFireIsFalse());
        return tours;
    }


>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/TourServiceImpl.java

}
