package sigma.project.travelAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sigma.project.travelAgency.entity.Hotel;

import java.util.Optional;
@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {

    boolean existsByHotelName(String name);

    Optional<Hotel> findByHotelName(String name);

}
