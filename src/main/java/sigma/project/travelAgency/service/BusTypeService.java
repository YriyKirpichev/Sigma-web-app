package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.BusType;

import java.util.List;

public interface BusTypeService {

    BusType createBusType(BusType busType);

    BusType getBusTypeByName(String name);

    boolean checkBusTypeName(String name);

    List<BusType> getAllBusType();

<<<<<<< HEAD
=======
    void deleteById(Long id);

    List<String> generateSeatCod(int seatCount);

>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
}
