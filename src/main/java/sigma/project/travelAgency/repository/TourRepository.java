package sigma.project.travelAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sigma.project.travelAgency.entity.Tour;

import java.util.Optional;
@Repository
public interface TourRepository extends JpaRepository<Tour,Long> {

    boolean existsByTitle(String title);

    Optional<Tour> findByTitle(String title);



}
