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
@Table(name = "bus")
public class Bus {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String firmName;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE},fetch = FetchType.LAZY)
    @JoinColumn(name = "busTypeId", nullable = false)
    private BusType busType;

    @JsonIgnore
    @ManyToMany(mappedBy = "bus", cascade = CascadeType.MERGE)
    private Collection<Tour> tour;

}
