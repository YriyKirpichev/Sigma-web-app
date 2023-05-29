package sigma.project.travelAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sigma.project.travelAgency.entity.BusType;

import java.util.Optional;
@Repository
public interface BusTypeRepository extends JpaRepository<BusType, Long> {

    boolean existsBusTypeByName(String name);

    Optional<BusType> findBusTypeByName(String name);

}
