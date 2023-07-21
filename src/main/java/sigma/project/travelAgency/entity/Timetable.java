package sigma.project.travelAgency.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Getter
@Setter
<<<<<<< HEAD
@Builder
=======
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
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
