package sigma.project.travelAgency.service;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sigma.project.travelAgency.entity.Hotel;
import sigma.project.travelAgency.entity.Room;
import sigma.project.travelAgency.repository.RoomRepository;
=======
import sigma.project.travelAgency.entity.Room;

>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22

import java.util.List;


public interface RoomService {


<<<<<<< HEAD
    Room createRoom(Room room);
=======
    List<Room> createRoom(List<Room> room);
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22

    List<Room> getRoomByNumberOfPeople(int numberOfPeople);

    boolean checkRoom (int numberOfPeople);

<<<<<<< HEAD
=======
    void deleteById(Long id);

>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
}
