<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/BusServiceImpl.java
package sigma.project.travelAgency.service.imp;

=======
package sigma.project.travelAgency.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/BusServiceImpl.java
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sigma.project.travelAgency.entity.Bus;
import sigma.project.travelAgency.entity.BusType;
import sigma.project.travelAgency.repository.BusRepository;
import sigma.project.travelAgency.service.BusService;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class BusServiceImpl implements BusService {

    private BusRepository busRepository;
<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/BusServiceImpl.java
=======
    private EntityManager entityManager;
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/BusServiceImpl.java


    @Override
    public Bus createBus(Bus bus,BusType busType) {
        log.info("Create Bus: '{}'", bus.getFirmName());
        bus.setBusType(busType);
        return busRepository.save(bus);
    }

<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/BusServiceImpl.java
    @Override
    public void delete(Long id) {
        log.info("Delete Bus by id: '{}'", id);
        busRepository.deleteById(id);
    }

=======

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Delete Bus by id: '{}'", id);

        Bus managedBus = entityManager.merge(busRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Bus doesn't exists")));
        entityManager.remove(managedBus);

    }
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/BusServiceImpl.java

    @Override
    public Bus getBusByName(String name) {
        log.info("Searching Bus by firm name: '{}'", name);
        return busRepository.findBusByFirmName(name)
                .orElseThrow(() -> new IllegalArgumentException("Bus doesn't exists"));
    }

    @Override
    public List<Bus> getBusByType(String name,BusType busType) {
        log.info("Searching Buses by Type: '{}'", busType.getName());
        return busRepository.findBusByFirmNameAndBusType(name, busType);
    }

    @Override
    public boolean checkBus(String name) {
        log.info("Check if Bus with name: '{}' exists", name);
        return busRepository.existsBusesByFirmName(name);
    }

    @Override
    public List<Bus> getAllBus() {
        return busRepository.findAll();
    }
}
