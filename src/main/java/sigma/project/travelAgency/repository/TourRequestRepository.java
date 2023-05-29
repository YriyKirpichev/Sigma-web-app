package sigma.project.travelAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sigma.project.travelAgency.entity.TourRequest;
import sigma.project.travelAgency.entity.User;

import java.util.List;
import java.util.Optional;
@Repository
public interface TourRequestRepository extends JpaRepository<TourRequest,Long> {

    Optional<TourRequest> findById(Long id);

    List<TourRequest> findByUser(User user);

    Optional<TourRequest> findTourRequestByStatusIsNullAndUser(User user);


}
