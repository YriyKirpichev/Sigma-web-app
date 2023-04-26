package sigma.project.travelAgency.service.imp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sigma.project.travelAgency.entity.Feature;
import sigma.project.travelAgency.repository.FeaturesRepository;
import sigma.project.travelAgency.service.FeatureService;

@Slf4j
@Service
@AllArgsConstructor
public class FeatureServiceImpl implements FeatureService {

    private FeaturesRepository featuresRepository;


    @Override
    public Feature create(Feature feature) {
        log.info("Create feature: '{}' '{}'", feature.getFeaturesName(),feature.getHorseType());
        return featuresRepository.save(feature);
    }

    @Override
    public void deleteFeature(Long id) {
        log.info("Delete feature by id: '{}'", id);
        featuresRepository.deleteById(id);
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
