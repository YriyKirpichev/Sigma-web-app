package sigma.project.travelAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sigma.project.travelAgency.entity.Companion;
import sigma.project.travelAgency.entity.Hotel;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanionRepository extends JpaRepository<Companion,Long> {

    boolean existsByPhone(String phone);

    Optional<Companion> findCompanionById(Long id);

    Companion findCompanionByHotel(Hotel hotel);



}
