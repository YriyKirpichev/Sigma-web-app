package sigma.project.travelAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sigma.project.travelAgency.entity.Bus;
import sigma.project.travelAgency.entity.BusType;

import java.util.List;
import java.util.Optional;
@Repository
public interface BusRepository extends JpaRepository<Bus,Long> {

    boolean existsBusesByFirmName(String name);

    Optional<Bus> findBusByFirmName(String name);

    List<Bus> findBusByFirmNameAndBusType(String name, BusType busType);

}
