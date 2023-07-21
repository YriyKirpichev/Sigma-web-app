package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.Companion;
import sigma.project.travelAgency.entity.Hotel;

public interface CompanionService {

    Companion create(Companion companion);

    Companion getCompanionById(Long id);

    boolean checkCompanion(String phone);

    Companion getCompanionByHotel(Hotel hotel);

<<<<<<< HEAD
    void deleteCompanion(Long id);
=======
    void deleteById(Long id);
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22

}
