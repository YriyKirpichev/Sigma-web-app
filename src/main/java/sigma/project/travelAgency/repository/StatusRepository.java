package sigma.project.travelAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sigma.project.travelAgency.entity.Status;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    Optional<Status> findStatusByName(String name);

    List<Status> findByDestination(String destination);

}
