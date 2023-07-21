package sigma.project.travelAgency.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
<<<<<<< HEAD
@Builder
=======
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "features")
public class Feature {

<<<<<<< HEAD
=======
    @Getter
    @Setter
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Getter
    @Setter
    private String horseType;


    @Getter
    @Setter
    private String featuresName;

    @JsonIgnore
    @ManyToMany(mappedBy = "features", cascade = CascadeType.MERGE)
    private Collection<Hotel> hotels;

}
