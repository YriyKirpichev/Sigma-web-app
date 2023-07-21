<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/FeatureServiceImpl.java
package sigma.project.travelAgency.service.imp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
=======
package sigma.project.travelAgency.service.impl;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/FeatureServiceImpl.java
import sigma.project.travelAgency.entity.Feature;
import sigma.project.travelAgency.repository.FeaturesRepository;
import sigma.project.travelAgency.service.FeatureService;

<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/FeatureServiceImpl.java
=======
import java.util.List;

>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/FeatureServiceImpl.java
@Slf4j
@Service
@AllArgsConstructor
public class FeatureServiceImpl implements FeatureService {

    private FeaturesRepository featuresRepository;
<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/FeatureServiceImpl.java


    @Override
    public Feature create(Feature feature) {
        log.info("Create feature: '{}' '{}'", feature.getFeaturesName(),feature.getHorseType());
        return featuresRepository.save(feature);
    }

    @Override
    public void deleteFeature(Long id) {
        log.info("Delete feature by id: '{}'", id);
        featuresRepository.deleteById(id);
=======
    private EntityManager entityManager;

    @Override
    public List<Feature> create(List<Feature> feature) {
      //  log.info("Create feature: '{}' '{}'", feature.getFeaturesName(),feature.getHorseType());
        return featuresRepository.saveAll(feature);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Delete feature by id: '{}'", id);
        Feature managedFeature = entityManager.merge(featuresRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Feature doesn't exists")));
        entityManager.remove(managedFeature);
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/FeatureServiceImpl.java
    }

    @Override
    public Feature getFeatureByName(String name) {
        log.info("Searching feature by name: '{}'", name);
        return featuresRepository.findByFeaturesName(name)
                .orElseThrow(() -> new IllegalArgumentException("Feature doesn't exists"));
    }

    @Override
    public boolean checkFeature(String name) {
        log.info("Check if Feature with name: '{}' exists", name);
        return featuresRepository.existsByFeaturesName(name);
    }
}
