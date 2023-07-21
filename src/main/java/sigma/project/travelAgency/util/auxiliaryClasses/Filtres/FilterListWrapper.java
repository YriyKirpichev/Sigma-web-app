package sigma.project.travelAgency.util.auxiliaryClasses.Filtres;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilterListWrapper {

    private List<String> filter = new ArrayList<>();

    public void addFilter(String value){
        filter.add(value);
    }
}
