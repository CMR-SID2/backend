package icesi.cmr.model.relational.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "roles")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    //----------------Relations----------------

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<UserRole> users;


}
