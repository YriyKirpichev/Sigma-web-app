package sigma.project.travelAgency.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
<<<<<<< HEAD
import org.hibernate.annotations.ManyToAny;
=======
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22

import java.io.Serializable;

@Entity
@Getter
@Setter
<<<<<<< HEAD
@Builder
=======
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "busType")
public class BusType implements Serializable {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

<<<<<<< HEAD
    private String seatCount;
=======
    private int seatCount;
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22

}
