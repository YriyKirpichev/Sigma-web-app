package sigma.project.travelAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sigma.project.travelAgency.entity.Tour;

<<<<<<< HEAD
import java.util.Optional;
@Repository
public interface TourRepository extends JpaRepository<Tour,Long> {
=======
import java.util.List;
import java.util.Optional;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22

    boolean existsByTitle(String title);

    Optional<Tour> findByTitle(String title);

<<<<<<< HEAD


=======
    Optional<Tour> findById(Long id);

    List<Tour> findToursByFlagFireIsTrue();
    List<Tour> findToursByFlagFireIsFalse();
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
}
