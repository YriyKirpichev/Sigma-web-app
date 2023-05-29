package sigma.project.travelAgency.util.auxiliaryClasses.Filtres;

import sigma.project.travelAgency.entity.Tour;

import java.util.Comparator;

public class FilterByHotelType implements Comparator<Tour> {
    @Override
    public int compare(Tour o1, Tour o2) {
        return o1.getHotel().getHotelClass().getHotelClassName().compareTo(o2.getHotel().getHotelClass().getHotelClassName());
    }
}
