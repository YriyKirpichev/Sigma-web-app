package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.Timetable;

import java.util.List;

public interface TimetableService {

    Timetable create(Timetable timetable);

    void delete(Long id);

    List<Timetable> findAll();

    boolean checkTimetable(String date);

    Timetable getTimetableByDepartureDate(String date);

}
