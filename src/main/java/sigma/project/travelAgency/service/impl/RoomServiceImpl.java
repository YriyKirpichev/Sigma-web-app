package sigma.project.travelAgency.service.impl;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import sigma.project.travelAgency.entity.Room;
import sigma.project.travelAgency.repository.RoomRepository;
import sigma.project.travelAgency.service.RoomService;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;
    private EntityManager entityManager;


    public List<Room> createRoom(List<Room> room){
        log.info("Create room for '{}' people", room.size());
        return roomRepository.saveAll(room);
    }

    @Override
    public List<Room> getRoomByNumberOfPeople(int numberOfPeople) {
        log.info("Searching Rooms for '{}' people", numberOfPeople);
        return roomRepository.getRoomsByNumberOfPeople(numberOfPeople);
    }

    @Override
    public boolean checkRoom(int numberOfPeople) {
        log.info("Check if Room for '{}' people exists",numberOfPeople);
        return roomRepository.existsByNumberOfPeople(numberOfPeople);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting room by id: '{}'", id);
        Room managedRoom = entityManager.merge(roomRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Room doesn't exists")));
        entityManager.remove(managedRoom);
    }
}
