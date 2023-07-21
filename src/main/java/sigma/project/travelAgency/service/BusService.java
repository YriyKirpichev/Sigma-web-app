package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.Bus;
import sigma.project.travelAgency.entity.BusType;

import java.util.List;

public interface BusService {

    Bus createBus (Bus bus,BusType busType);

<<<<<<< HEAD
    void delete(Long id);
=======
    void deleteById(Long id);
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22

    Bus getBusByName(String name);

    List<Bus> getBusByType(String name,BusType busType);

    boolean checkBus(String name);

    List<Bus> getAllBus();

}
