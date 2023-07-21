package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.Timetable;

import java.util.List;

public interface TimetableService {

    List<Timetable> create(List<Timetable> timetable);

    void deleteById(Long id);

    List<Timetable> findAll();

    Timetable findById(Long id);

    boolean checkTimetable(String date);

    Timetable getTimetableByDepartureDate(String date);

}
