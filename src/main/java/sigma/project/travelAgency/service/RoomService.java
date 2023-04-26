package sigma.project.travelAgency.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sigma.project.travelAgency.entity.Hotel;
import sigma.project.travelAgency.entity.Room;
import sigma.project.travelAgency.repository.RoomRepository;

import java.util.List;


public interface RoomService {


    Room createRoom(Room room);

    List<Room> getRoomByNumberOfPeople(int numberOfPeople);

    boolean checkRoom (int numberOfPeople);

}
