package sigma.project.travelAgency.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sigma.project.travelAgency.entity.*;
import sigma.project.travelAgency.repository.HotelRepository;
import sigma.project.travelAgency.service.HotelService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel, Room room, Feature feature, Companion companion, HotelClass hotelClass) {
        log.info("Create Hotel: '{}'", hotel.getHotelName());

        hotel.setHotelClass(hotelClass);
        hotel.setCompanion(companion);

        List<Feature> features = new ArrayList<>();
        features.add(feature);
        hotel.setFeatures(features);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        hotel.setRooms(rooms);

        return hotelRepository.save(hotel);
    }

    @Override
    public void delete(Long id) {
        log.info("Delete hotel by id: '{}'",id );
        hotelRepository.deleteById(id);
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
