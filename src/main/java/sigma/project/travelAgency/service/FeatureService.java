package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.Feature;

<<<<<<< HEAD
public interface FeatureService {

    Feature create (Feature feature);

    void deleteFeature (Long id);
=======
import java.util.List;

public interface FeatureService {

    List<Feature> create (List<Feature> feature);

    void deleteById(Long id);
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22

    Feature getFeatureByName(String name);

    boolean checkFeature(String name);

}
