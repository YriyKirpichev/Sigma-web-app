package sigma.project.travelAgency.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sigma.project.travelAgency.entity.Room;
import sigma.project.travelAgency.repository.RoomRepository;
import sigma.project.travelAgency.service.RoomService;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;


    public Room createRoom(Room room){
        log.info("Create room for '{}' people", room.getNumberOfPeople());
        return roomRepository.save(room);
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
}
