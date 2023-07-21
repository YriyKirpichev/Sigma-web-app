<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/BusTypeServiceImpl.java
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
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/BusTypeServiceImpl.java
import sigma.project.travelAgency.entity.BusType;
import sigma.project.travelAgency.repository.BusTypeRepository;
import sigma.project.travelAgency.service.BusTypeService;

<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/BusTypeServiceImpl.java
=======
import java.util.ArrayList;
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/BusTypeServiceImpl.java
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class BusTypeServiceImpl implements BusTypeService {

    private BusTypeRepository busTypeRepository;
<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/BusTypeServiceImpl.java
=======
    private EntityManager entityManager;
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/BusTypeServiceImpl.java

    @Override
    public BusType createBusType(BusType busType) {
        log.info("Added Bus Type: '{},{}'",busType.getName(), busType.getSeatCount());
        return busTypeRepository.save(busType);
    }

    @Override
    public BusType getBusTypeByName(String name) {

        log.info("Searching Bus Type by Name: '{}'", name);
        return busTypeRepository.findBusTypeByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Bus Type doesn't exists"));
    }

    @Override
    public boolean checkBusTypeName(String name) {
        log.info("Check if Bus Type with name: '{}' exists", name);
        return busTypeRepository.existsBusTypeByName(name);
    }

    @Override
    public List<BusType> getAllBusType() {
        return busTypeRepository.findAll();
    }
<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/BusTypeServiceImpl.java
=======

    @Override
    @Transactional
    public void deleteById(Long id){
        log.info("Deleting Bus Type by id: '{}'", id);
        BusType managedBusType = entityManager.merge(busTypeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Bus Type doesn't exists")));
        entityManager.remove(managedBusType);
    }

    @Override
    public List<String> generateSeatCod(int seatCount){
        List<String> seatCodes = new ArrayList<>();
        int rows = (int) Math.ceil((double) seatCount / 4);
        char rowChar = 'A';

        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= 4 && seatCodes.size() < seatCount; col++) {
                String seatCode = rowChar + String.valueOf(col);
                seatCodes.add(seatCode);
            }
            rowChar++;
        }

        return seatCodes;
    }
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/BusTypeServiceImpl.java
}
