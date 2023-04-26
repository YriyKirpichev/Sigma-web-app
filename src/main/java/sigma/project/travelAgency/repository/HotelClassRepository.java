package sigma.project.travelAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sigma.project.travelAgency.entity.HotelClass;

import java.util.List;
import java.util.Optional;
@Repository
public interface HotelClassRepository extends JpaRepository<HotelClass,Long> {

    boolean existsByHotelClassName(String classname);

    Optional<HotelClass> findByHotelClassName(String name);

}
