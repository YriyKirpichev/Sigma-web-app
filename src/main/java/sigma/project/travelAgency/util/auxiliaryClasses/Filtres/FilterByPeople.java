package sigma.project.travelAgency.util.auxiliaryClasses.Filtres;

import sigma.project.travelAgency.entity.Tour;
import java.util.Comparator;


public class FilterByPeople implements Comparator<Tour> {

    @Override
    public int compare(Tour o1, Tour o2) {
        return Double.compare(o1.getNumberOfPeople(), o2.getNumberOfPeople());
    }
}

