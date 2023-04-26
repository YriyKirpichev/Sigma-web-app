package sigma.project.travelAgency.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "timetable")
public class Timetable {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departureDate;

    private String dateArrivalAtHotel;

    private String dateCheckoutFromHotel;

    private String arrivalDate;

    @JsonIgnore
    @ManyToMany(mappedBy = "timetable", cascade = CascadeType.MERGE)
    private Collection<Tour> tour;

}
