package sigma.project.travelAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sigma.project.travelAgency.entity.Status;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    Optional<Status> findStatusByName(String name);

<<<<<<< HEAD
=======
    List<Status> findByDestination(String destination);

>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
}
