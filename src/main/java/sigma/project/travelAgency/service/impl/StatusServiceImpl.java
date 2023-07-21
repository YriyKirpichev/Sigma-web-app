package sigma.project.travelAgency.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sigma.project.travelAgency.entity.Status;
import sigma.project.travelAgency.repository.StatusRepository;
import sigma.project.travelAgency.service.StatusService;

import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class StatusServiceImpl implements StatusService {

    private StatusRepository statusRepository;

    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status getStatusByName(String name){
        return statusRepository.findStatusByName(name).orElseThrow(() -> new IllegalArgumentException("Status doesn't exists"));
    }

    @Override
    public Status findById(Long id) {
        return statusRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Status doesn't exists"));
    }

    @Override
    public List<Status> getStatusByDestination(String destination) {
        return statusRepository.findByDestination(destination);
    }
}
