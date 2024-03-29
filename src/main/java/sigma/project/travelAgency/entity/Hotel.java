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
@Table(name = "hotels")
public class Hotel {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotelName;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE},fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_class_id", nullable = false)
    private HotelClass hotelClass;

    private String hotelLocation;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "companion_id", nullable = false, unique = true)
    private Companion companion;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE},
            fetch = FetchType.EAGER)
    @JoinTable(name = "hotels_rooms",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id"))
    private Collection<Room> rooms;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE},
            fetch = FetchType.EAGER)
    @JoinTable(name = "hotels_features",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id"))
    private Collection<Feature> features;

}
