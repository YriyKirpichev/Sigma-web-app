package sigma.project.travelAgency.service.imp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sigma.project.travelAgency.entity.Timetable;
import sigma.project.travelAgency.repository.TimetableRepository;
import sigma.project.travelAgency.service.TimetableService;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TimetableServiceImpl  implements TimetableService {

    private TimetableRepository timetableRepository;

    @Override
    public Timetable create(Timetable timetable) {
        log.info("Create Timetable: '{}' - '{}'", timetable.getDepartureDate(), timetable.getDateCheckoutFromHotel());
        return timetableRepository.save(timetable);
    }

    @Override
    public void delete(Long id) {
        log.info("Delete Timetable by id: '{}'", id);
        timetableRepository.deleteById(id);
    }

    @Override
    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }

    @Override
    public boolean checkTimetable(String date) {
        log.info("Check if Timetable with DepartureDate: '{}' exists", date);
        return timetableRepository.existsByDepartureDate(date);
    }

    @Override
    public Timetable getTimetableByDepartureDate(String date) {
        log.info("Searching Timetable with DepartureDate: '{}'", date);
        return timetableRepository.findByDepartureDate(date)
                .orElseThrow(() -> new IllegalArgumentException("Timetable doesn't exists"));
    }
}
