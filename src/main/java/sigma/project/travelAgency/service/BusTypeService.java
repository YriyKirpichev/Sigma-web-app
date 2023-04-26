package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.BusType;

import java.util.List;

public interface BusTypeService {

    BusType createBusType(BusType busType);

    BusType getBusTypeByName(String name);

    boolean checkBusTypeName(String name);

    List<BusType> getAllBusType();

}
