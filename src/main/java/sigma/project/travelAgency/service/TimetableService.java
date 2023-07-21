package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.Timetable;

import java.util.List;

public interface TimetableService {

<<<<<<< HEAD
    Timetable create(Timetable timetable);

    void delete(Long id);

    List<Timetable> findAll();

=======
    List<Timetable> create(List<Timetable> timetable);

    void deleteById(Long id);

    List<Timetable> findAll();

    Timetable findById(Long id);

>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
    boolean checkTimetable(String date);

    Timetable getTimetableByDepartureDate(String date);

}
