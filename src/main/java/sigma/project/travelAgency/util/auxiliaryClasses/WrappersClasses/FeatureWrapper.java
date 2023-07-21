package sigma.project.travelAgency.util.auxiliaryClasses.WrappersClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sigma.project.travelAgency.entity.Feature;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeatureWrapper {

    private List<Feature> featureList = new ArrayList<>();

    public void addFeatures(Feature feature){
        featureList.add(feature);
    }

}
