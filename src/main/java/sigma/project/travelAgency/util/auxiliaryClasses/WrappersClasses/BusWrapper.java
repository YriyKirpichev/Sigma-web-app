package sigma.project.travelAgency.util.auxiliaryClasses.WrappersClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sigma.project.travelAgency.entity.Bus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusWrapper {

    private List<Bus> busList = new ArrayList<>();

    public void addBus(Bus bus){
        busList.add(bus);
    }

}
