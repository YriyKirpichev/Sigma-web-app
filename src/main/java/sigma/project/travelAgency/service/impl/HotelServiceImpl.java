<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/HotelServiceImpl.java
package sigma.project.travelAgency.service.imp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
=======
package sigma.project.travelAgency.service.impl;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/HotelServiceImpl.java
import sigma.project.travelAgency.entity.*;
import sigma.project.travelAgency.repository.HotelRepository;
import sigma.project.travelAgency.service.HotelService;

<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/HotelServiceImpl.java
import java.util.ArrayList;
import java.util.Collection;
=======
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/HotelServiceImpl.java
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;
<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/HotelServiceImpl.java

    @Override
    public Hotel createHotel(Hotel hotel, Room room, Feature feature, Companion companion, HotelClass hotelClass) {
=======
    private EntityManager entityManager;

    @Override
    public Hotel createHotel(Hotel hotel, List<Room> rooms, List<Feature> features, Companion companion, HotelClass hotelClass) {
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/HotelServiceImpl.java
        log.info("Create Hotel: '{}'", hotel.getHotelName());

        hotel.setHotelClass(hotelClass);
        hotel.setCompanion(companion);

<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/HotelServiceImpl.java
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        hotel.setFeatures(features);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
=======
        hotel.setFeatures(features);

>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/HotelServiceImpl.java
        hotel.setRooms(rooms);

        return hotelRepository.save(hotel);
    }

    @Override
<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/HotelServiceImpl.java
    public void delete(Long id) {
        log.info("Delete hotel by id: '{}'",id );
        hotelRepository.deleteById(id);
=======
    @Transactional
    public void deleteById(Long id) {
        log.info("Delete hotel by id: '{}'",id );
        Hotel managedHotel = entityManager.merge(hotelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Hotel doesn't exists")));
        entityManager.remove(managedHotel);
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/HotelServiceImpl.java
    }

    @Override
    public Hotel findByName(String name) {
        log.info("Searching hotel by name: '{}'", name);
        return hotelRepository.findByHotelName(name)
                .orElseThrow(() -> new IllegalArgumentException("Hotel doesn't exists"));
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public boolean checkHotel(String name) {
        log.info("Check if hotel with name: '{}' exists", name);
        return hotelRepository.existsByHotelName(name);
    }
}
