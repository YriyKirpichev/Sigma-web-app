package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.Feature;

import java.util.List;

public interface FeatureService {

    List<Feature> create (List<Feature> feature);

    void deleteById(Long id);

    Feature getFeatureByName(String name);

    boolean checkFeature(String name);

}
