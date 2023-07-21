<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/HotelClassServiceImpl.java
package sigma.project.travelAgency.service.imp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sigma.project.travelAgency.entity.Hotel;
=======
package sigma.project.travelAgency.service.impl;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/HotelClassServiceImpl.java
import sigma.project.travelAgency.entity.HotelClass;
import sigma.project.travelAgency.repository.HotelClassRepository;
import sigma.project.travelAgency.service.HotelClassService;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class HotelClassServiceImpl implements HotelClassService{

    private HotelClassRepository hotelClassRepository;
<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/HotelClassServiceImpl.java
=======
    private EntityManager entityManager;
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/HotelClassServiceImpl.java


    @Override
    public HotelClass createClass(HotelClass hotelClass) {
        log.info("Create Hotel Class: '{}'", hotelClass.getHotelClassName());
        return hotelClassRepository.save(hotelClass);
    }

    @Override
<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/HotelClassServiceImpl.java
    public void deleteHotelClassById(Long id) {
        log.info("Delete Hotel Class with id: '{}'", id);
        hotelClassRepository.deleteById(id);
=======
    @Transactional
    public void deleteById(Long id) {
        log.info("Delete Hotel Class with id: '{}'", id);
        HotelClass managedHotelClass = entityManager.merge(hotelClassRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Hotel Class doesn't exists")));
        entityManager.remove(managedHotelClass);
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/HotelClassServiceImpl.java
    }

    @Override
    public HotelClass getHotelClassByName(String name) {
        log.info("Searching Hotel Class by name: '{}'", name);
        return hotelClassRepository.findByHotelClassName(name)
                .orElseThrow(() -> new IllegalArgumentException("Hotel Class doesn't exists"));
    }

    @Override
    public List<HotelClass> findAll() {
        return hotelClassRepository.findAll();
    }
}
