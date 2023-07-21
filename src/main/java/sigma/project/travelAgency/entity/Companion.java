package sigma.project.travelAgency.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
<<<<<<< HEAD
@Builder
=======
>>>>>>> 5e2c4e0f711bd9e60908d3dbaa6c0db260cd0d22
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "companions")
public class Companion {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String secondName;

    private String phone;

    @OneToOne(mappedBy = "companion", fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

}
