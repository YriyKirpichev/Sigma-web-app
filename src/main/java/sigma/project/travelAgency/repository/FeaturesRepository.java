package sigma.project.travelAgency.repository;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sigma.project.travelAgency.entity.Feature;

import java.util.Optional;
@Repository
public interface FeaturesRepository extends JpaRepository<Feature,Long> {

    boolean existsByFeaturesName(String name);

    Optional<Feature> findByFeaturesName(String name);

    }
