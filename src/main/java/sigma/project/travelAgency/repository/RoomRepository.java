package sigma.project.travelAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sigma.project.travelAgency.entity.Hotel;
import sigma.project.travelAgency.entity.Room;

import java.util.Collection;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

    Room getRoomByNumberOfPeople(int number);

    List<Room> getRoomsByNumberOfPeople(int numberOfPeople);

    boolean existsByNumberOfPeople(int number);

}
