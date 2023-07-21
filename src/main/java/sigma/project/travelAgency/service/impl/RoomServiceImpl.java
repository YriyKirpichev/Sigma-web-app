<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/RoomServiceImpl.java
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
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/RoomServiceImpl.java
import sigma.project.travelAgency.entity.Room;
import sigma.project.travelAgency.repository.RoomRepository;
import sigma.project.travelAgency.service.RoomService;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;
<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/RoomServiceImpl.java


    public Room createRoom(Room room){
        log.info("Create room for '{}' people", room.getNumberOfPeople());
        return roomRepository.save(room);
=======
    private EntityManager entityManager;


    public List<Room> createRoom(List<Room> room){
        log.info("Create room for '{}' people", room.size());
        return roomRepository.saveAll(room);
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/RoomServiceImpl.java
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
<<<<<<< HEAD:src/main/java/sigma/project/travelAgency/service/imp/RoomServiceImpl.java
=======

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting room by id: '{}'", id);
        Room managedRoom = entityManager.merge(roomRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Room doesn't exists")));
        entityManager.remove(managedRoom);
    }
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22:src/main/java/sigma/project/travelAgency/service/impl/RoomServiceImpl.java
}
