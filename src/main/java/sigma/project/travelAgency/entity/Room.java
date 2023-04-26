package sigma.project.travelAgency.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private int numberOfPeople;

    @JsonIgnore
    @ManyToMany(mappedBy = "rooms", cascade = CascadeType.MERGE)
    private Collection<Hotel> hotels;

}
