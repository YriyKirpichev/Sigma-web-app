package sigma.project.travelAgency.util.auxiliaryClasses.Filtres;

import sigma.project.travelAgency.entity.Tour;

import java.util.Comparator;

public class FilterCost implements Comparator<Tour> {

    @Override
    public int compare(Tour h1, Tour h2) {
        return Double.compare(h1.getCost(), h2.getCost());
    }

    @Override
    public Comparator<Tour> reversed() {
        return Comparator.super.reversed();
    }
}
