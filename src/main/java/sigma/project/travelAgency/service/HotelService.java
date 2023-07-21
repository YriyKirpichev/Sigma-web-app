package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.*;

import java.util.List;

public interface HotelService {

<<<<<<< HEAD
    Hotel createHotel(Hotel hotel, Room room, Feature feature, Companion companion, HotelClass hotelClass);

    void delete(Long id);
=======
    Hotel createHotel(Hotel hotel, List<Room> room, List<Feature> features, Companion companion, HotelClass hotelClass);

    void deleteById(Long id);
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22

    Hotel findByName(String name);

    List<Hotel> findAll();

    boolean checkHotel(String name);

}
