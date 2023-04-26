package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.Bus;
import sigma.project.travelAgency.entity.BusType;

import java.util.List;

public interface BusService {

    Bus createBus (Bus bus,BusType busType);

    void delete(Long id);

    Bus getBusByName(String name);

    List<Bus> getBusByType(String name,BusType busType);

    boolean checkBus(String name);

    List<Bus> getAllBus();

}
