package sigma.project.travelAgency.service.imp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sigma.project.travelAgency.entity.*;
import sigma.project.travelAgency.repository.StatusRepository;
import sigma.project.travelAgency.repository.TourRepository;
import sigma.project.travelAgency.service.TourService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class TourServiceImpl implements TourService {

    private TourRepository tourRepository;
    private StatusRepository statusRepository;

    @Override
    public Tour createTour(Tour tour, Timetable timetable, Hotel hotel, Bus bus) {
        log.info("Create Tour: '{}'", tour.getTitle());

        List<Bus> buses = new ArrayList<>();
        buses.add(bus);
        tour.setBus(buses);

        tour.setHotel(hotel);

        List<Timetable> timetables = new ArrayList<>();
        timetables.add(timetable);
        tour.setTimetable(timetables);

        Status status = statusRepository.findStatusByName("Доступно").stream()
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Tour cannot be created"));

        tour.setStatus(status);

        return tourRepository.save(tour);
    }

    @Override
    public void deleteTour(Long id) {
        log.info("Delete Tour by id: '{}'", id);
        tourRepository.deleteById(id);
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


}
