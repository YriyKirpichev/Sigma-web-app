package sigma.project.travelAgency.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles", cascade = CascadeType.MERGE)
    private Collection<User> users;

}
