<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/TimetableServiceImpl.java
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
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/TimetableServiceImpl.java
import sigma.project.travelAgency.entity.Timetable;
import sigma.project.travelAgency.repository.TimetableRepository;
import sigma.project.travelAgency.service.TimetableService;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TimetableServiceImpl  implements TimetableService {

    private TimetableRepository timetableRepository;
<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/TimetableServiceImpl.java

    @Override
    public Timetable create(Timetable timetable) {
        log.info("Create Timetable: '{}' - '{}'", timetable.getDepartureDate(), timetable.getDateCheckoutFromHotel());
        return timetableRepository.save(timetable);
    }

    @Override
    public void delete(Long id) {
        log.info("Delete Timetable by id: '{}'", id);
        timetableRepository.deleteById(id);
=======
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
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/TimetableServiceImpl.java
    }

    @Override
    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }

<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/TimetableServiceImpl.java
=======

    @Override
    public Timetable findById(Long id){
        return timetableRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Timetable doesn't exists"));
    }

>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/TimetableServiceImpl.java
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
