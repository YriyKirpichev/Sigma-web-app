package sigma.project.travelAgency.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "features")
public class Feature {

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
