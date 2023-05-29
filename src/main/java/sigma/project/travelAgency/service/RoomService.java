package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.Room;


import java.util.List;


public interface RoomService {


    List<Room> createRoom(List<Room> room);

    List<Room> getRoomByNumberOfPeople(int numberOfPeople);

    boolean checkRoom (int numberOfPeople);

    void deleteById(Long id);

}
