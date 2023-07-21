package sigma.project.travelAgency.service;

<<<<<<< HEAD
import sigma.project.travelAgency.entity.Hotel;
=======
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
import sigma.project.travelAgency.entity.HotelClass;

import java.util.List;

public interface HotelClassService {

    HotelClass createClass(HotelClass hotelClass);

<<<<<<< HEAD
    void deleteHotelClassById(Long id);
=======
    void deleteById(Long id);
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22

    HotelClass getHotelClassByName(String name);

    List<HotelClass> findAll();

}
