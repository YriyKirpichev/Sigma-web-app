package sigma.project.travelAgency.util.auxiliaryClasses.WrappersClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sigma.project.travelAgency.entity.BusType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusTypeWrapper {

    private List<BusType> busTypeList = new ArrayList<>();

    public void addBusType(BusType busType){
        busTypeList.add(busType);
    }

}
