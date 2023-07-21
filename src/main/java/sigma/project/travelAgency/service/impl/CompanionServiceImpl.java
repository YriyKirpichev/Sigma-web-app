<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/CompanionServiceImpl.java
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
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/CompanionServiceImpl.java
import sigma.project.travelAgency.entity.Companion;
import sigma.project.travelAgency.entity.Hotel;
import sigma.project.travelAgency.repository.CompanionRepository;
import sigma.project.travelAgency.service.CompanionService;


@Slf4j
@Service
@AllArgsConstructor
public class CompanionServiceImpl implements CompanionService {

    private CompanionRepository companionRepository;
<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/CompanionServiceImpl.java
=======
    private EntityManager entityManager;
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/CompanionServiceImpl.java

    @Override
    public Companion create(Companion companion) {
        log.info("Create companion: '{}' '{}'", companion.getFirstName() , companion.getSecondName());
        return companionRepository.save(companion);
    }

    @Override
    public Companion getCompanionById(Long id) {
        log.info("Searching companion by id: '{}'", id);
        return companionRepository.findCompanionById(id)
                .orElseThrow(() -> new IllegalArgumentException("Companion doesn't exists"));
    }

    @Override
    public boolean checkCompanion(String phone) {
        return companionRepository.existsByPhone(phone);
    }

    @Override
    public Companion getCompanionByHotel(Hotel hotel) {
        log.info("Searching companion by hotel: '{}'", hotel.getHotelName());
        return companionRepository.findCompanionByHotel(hotel);
    }

    @Override
<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/CompanionServiceImpl.java
    public void deleteCompanion(Long id) {
        log.info("Deleting companion by id: '{}'", id);
        companionRepository.deleteById(id);
=======
    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting companion by id: '{}'", id);
        Companion managedCompanion = entityManager.merge(companionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Companion doesn't exists")));
        entityManager.remove(managedCompanion);
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/CompanionServiceImpl.java
    }
}
