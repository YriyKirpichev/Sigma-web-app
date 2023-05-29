package sigma.project.travelAgency.service.impl;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import sigma.project.travelAgency.entity.*;
import sigma.project.travelAgency.repository.StatusRepository;
import sigma.project.travelAgency.repository.TourRepository;
import sigma.project.travelAgency.service.TourService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TourServiceImpl implements TourService {

    private TourRepository tourRepository;
    private StatusRepository statusRepository;

    private EntityManager entityManager;

    @Override
    public Tour createTour(Tour tour, List<Timetable> timetables, Hotel hotel, Bus bus,String image) {
        log.info("Create Tour: '{}'", tour.getTitle());

        List<Bus> buses = new ArrayList<>();
        buses.add(bus);
        tour.setBus(buses);

        tour.setHotel(hotel);

        tour.setTimetable(timetables);

        Status status = statusRepository.findStatusByName("Доступно").stream()
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Tour cannot be created"));

        tour.setStatus(status);

        tour.setImage(image);

        return tourRepository.save(tour);
    }

    @Override
    public Tour createTourTest(Tour tour) {
        return tourRepository.save(tour);
    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Delete Tour by id: '{}'", id);
        Tour managedTour = entityManager.merge(tourRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Timetable doesn't exists")));
        entityManager.remove(managedTour);
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



}
