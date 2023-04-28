package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.*;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel, Room room, Feature feature, Companion companion, HotelClass hotelClass);

    void delete(Long id);

    Hotel findByName(String name);

    List<Hotel> findAll();

    boolean checkHotel(String name);

}
