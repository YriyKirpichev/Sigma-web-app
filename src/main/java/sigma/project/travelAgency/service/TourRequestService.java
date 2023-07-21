package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.Status;
import sigma.project.travelAgency.entity.TourRequest;
import sigma.project.travelAgency.entity.User;

import java.util.Comparator;
import java.util.List;

public interface TourRequestService extends Comparator<TourRequest> {

    List<TourRequest> getAllRequests();

    void changeStatus(Status status, Long id);

    TourRequest findById(Long id);

    TourRequest createRequest(TourRequest tourRequest);

    TourRequest updateRequest(TourRequest tourRequest);

    void deleteById(Long id);

    public List<TourRequest> findByUser(User user);

    public TourRequest findTourRequestByStatusIsNullAndUser(User user);
}
