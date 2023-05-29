package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.Status;

import java.util.List;

public interface StatusService {

    List<Status> getStatusByDestination(String destination);

    Status getStatusByName(String name);

    Status findById(Long id);

}
