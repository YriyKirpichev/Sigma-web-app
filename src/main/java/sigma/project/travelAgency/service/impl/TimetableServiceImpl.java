package sigma.project.travelAgency.service.impl;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import sigma.project.travelAgency.entity.Timetable;
import sigma.project.travelAgency.repository.TimetableRepository;
import sigma.project.travelAgency.service.TimetableService;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TimetableServiceImpl  implements TimetableService {

    private TimetableRepository timetableRepository;
    private EntityManager entityManager;

    @Override
    public List<Timetable> create(List<Timetable> timetable) {
        log.info("Create Timetable:" + timetable.size());
        return timetableRepository.saveAll(timetable);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Delete Timetable by id: '{}'", id);
        Timetable managedTimetable = entityManager.merge(timetableRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Timetable doesn't exists")));
        entityManager.remove(managedTimetable);
    }

    @Override
    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }


    @Override
    public Timetable findById(Long id){
        return timetableRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Timetable doesn't exists"));
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
