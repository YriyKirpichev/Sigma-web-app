package sigma.project.travelAgency.util.auxiliaryClasses.WrappersClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sigma.project.travelAgency.entity.Room;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomWrapper {

    private List<Room> roomList = new ArrayList<>();

    public void addRoom(Room room){
        roomList.add(room);
    }

}
