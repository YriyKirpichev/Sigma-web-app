package sigma.project.travelAgency.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sigma.project.travelAgency.entity.Status;
import sigma.project.travelAgency.entity.TourRequest;
import sigma.project.travelAgency.entity.User;
import sigma.project.travelAgency.repository.StatusRepository;
import sigma.project.travelAgency.repository.TourRequestRepository;
import sigma.project.travelAgency.service.TourRequestService;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TourRequestServiceImpl implements TourRequestService {

    private TourRequestRepository tourRequestRepository;

    private StatusRepository statusRepository;

    @Override
    public List<TourRequest> getAllRequests() {
        return tourRequestRepository.findAll();
    }

    @Override
    public void changeStatus(Status status, Long id) {
        TourRequest tourRequest = tourRequestRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Request doesn't exists"));
        tourRequest.setStatus(statusRepository.findById(status.getId()).orElseThrow(() -> new IllegalArgumentException("Status doesn't exists")));
        tourRequestRepository.save(tourRequest);
    }

    @Override
    public TourRequest findById(Long id) {
        return tourRequestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Request doesn't exists"));
    }

    @Override
    public TourRequest createRequest(TourRequest tourRequest) {
        return tourRequestRepository.save(tourRequest);
    }

    @Override
    public TourRequest updateRequest(TourRequest tourRequest) {
        return tourRequestRepository.save(tourRequest);
    }

    @Override
    public void deleteById(Long id) {
        tourRequestRepository.deleteById(id);
    }

    @Override
    public List<TourRequest> findByUser(User user) {
        return tourRequestRepository.findByUser(user);
    }

    @Override
    public TourRequest findTourRequestByStatusIsNullAndUser(User user) {
        return tourRequestRepository.findTourRequestByStatusIsNullAndUser(user).orElseThrow(() -> new IllegalArgumentException("Request doesn't exists"));
    }

    @Override
    public int compare(TourRequest o1, TourRequest o2) {
        int dateCompare = o1.getOrderDate().compareTo(o2.getOrderDate());
        if(dateCompare !=0){
            return dateCompare;
        }
        return Long.compare(o1.getId(),o2.getId());
    }

}
