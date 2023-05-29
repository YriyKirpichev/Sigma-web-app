package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.*;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel, List<Room> room, List<Feature> features, Companion companion, HotelClass hotelClass);

    void deleteById(Long id);

    Hotel findByName(String name);

    List<Hotel> findAll();

    boolean checkHotel(String name);

}
