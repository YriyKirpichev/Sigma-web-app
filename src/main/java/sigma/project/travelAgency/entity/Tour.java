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
@Table(name = "tour")
public class Tour {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE},
            fetch = FetchType.EAGER)
    @JoinTable(name = "tours_buses",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "bus_id"))
    private Collection<Bus> bus;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE},fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE},fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    private int count;

    private String title;

    private String description;

    private double cost;

    private boolean flagFire;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE},
            fetch = FetchType.EAGER)
    @JoinTable(name = "tours_timetable",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "timetable_id"))
    private Collection<Timetable> timetable;

    public String getBusFirmName(){
        return bus.iterator().next().getFirmName();
    }

}
