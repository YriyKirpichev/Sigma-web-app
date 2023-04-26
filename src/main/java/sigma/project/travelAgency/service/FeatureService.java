package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.Feature;

public interface FeatureService {

    Feature create (Feature feature);

    void deleteFeature (Long id);

    Feature getFeatureByName(String name);

    boolean checkFeature(String name);

}
