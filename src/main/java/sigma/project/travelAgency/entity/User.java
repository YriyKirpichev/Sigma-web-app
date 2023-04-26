package sigma.project.travelAgency.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements Serializable {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
    private String firstName ;

    private String secondName ;

    private String middleName ;

    private String username ; // email

    private String phone ;

    @JsonIgnore
    private String password ;

    private boolean isBanned;

    @JsonIgnore
    private String banDescription ;

    private double Sale;

    private String birthDate;

//    @JsonIgnore
//    @Column(name = "image_id")
//    private String imageId;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE},
            fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

}
