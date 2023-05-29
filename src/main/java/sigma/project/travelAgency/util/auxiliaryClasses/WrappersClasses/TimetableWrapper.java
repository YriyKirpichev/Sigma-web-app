package sigma.project.travelAgency.util.auxiliaryClasses.WrappersClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sigma.project.travelAgency.entity.Timetable;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimetableWrapper {

    private List<Timetable> timetableList = new ArrayList<>();

    public void addTimetable (Timetable timetable){
        this.timetableList.add(timetable);
    }
}
