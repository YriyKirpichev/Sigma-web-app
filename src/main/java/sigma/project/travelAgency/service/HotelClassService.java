package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.HotelClass;

import java.util.List;

public interface HotelClassService {

    HotelClass createClass(HotelClass hotelClass);

    void deleteById(Long id);

    HotelClass getHotelClassByName(String name);

    List<HotelClass> findAll();

}
