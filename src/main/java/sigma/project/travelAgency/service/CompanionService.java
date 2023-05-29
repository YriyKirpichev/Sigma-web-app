package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.Companion;
import sigma.project.travelAgency.entity.Hotel;

public interface CompanionService {

    Companion create(Companion companion);

    Companion getCompanionById(Long id);

    boolean checkCompanion(String phone);

    Companion getCompanionByHotel(Hotel hotel);

    void deleteById(Long id);

}
