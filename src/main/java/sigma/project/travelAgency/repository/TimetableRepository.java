package sigma.project.travelAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sigma.project.travelAgency.entity.Timetable;

import java.util.Optional;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable,Long> {

    boolean existsByDepartureDate(String date);

    Optional<Timetable> findByDepartureDate(String date);

}
