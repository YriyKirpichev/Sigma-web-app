package sigma.project.travelAgency.service.impl;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import sigma.project.travelAgency.entity.*;
import sigma.project.travelAgency.repository.HotelRepository;
import sigma.project.travelAgency.service.HotelService;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;
    private EntityManager entityManager;

    @Override
    public Hotel createHotel(Hotel hotel, List<Room> rooms, List<Feature> features, Companion companion, HotelClass hotelClass) {
        log.info("Create Hotel: '{}'", hotel.getHotelName());

        hotel.setHotelClass(hotelClass);
        hotel.setCompanion(companion);

        hotel.setFeatures(features);

        hotel.setRooms(rooms);

        return hotelRepository.save(hotel);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Delete hotel by id: '{}'",id );
        Hotel managedHotel = entityManager.merge(hotelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Hotel doesn't exists")));
        entityManager.remove(managedHotel);
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
