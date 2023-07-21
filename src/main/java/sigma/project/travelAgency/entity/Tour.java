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


<<<<<<< HEAD
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE},fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE},fetch = FetchType.LAZY)
=======
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE},fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE},fetch = FetchType.EAGER)
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    private int count;

    private String title;

    private String description;

    private double cost;

    private boolean flagFire;

<<<<<<< HEAD
=======
    private String image;

>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
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

<<<<<<< HEAD
=======
    public String getHorseType(){
        return hotel.getFeatures().iterator().next().getHorseType();
    }

    public String getFeaturesName(){
        return hotel.getFeatures().iterator().next().getFeaturesName();
    }

    public int getNumberOfPeople(){
        return hotel.getRooms().iterator().next().getNumberOfPeople();
    }

    public String getDepartureDate(){
        return timetable.iterator().next().getDepartureDate();
    }

    public String getDateArrivalAtHotel(){
        return timetable.iterator().next().getDateArrivalAtHotel();
    }

    public String getDateCheckoutFromHotel(){
        return timetable.iterator().next().getDateCheckoutFromHotel();
    }

    public String getArrivalDate(){
        return timetable.iterator().next().getArrivalDate();
    }

    public String getBusTypeName(){
        return bus.iterator().next().getBusType().getName();
    }

    public int getBusTypeSeatCount(){
        return bus.iterator().next().getBusType().getSeatCount();
    }

>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
}
