package pl.arturzaczek.exercise34.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", length = 30, unique = true)
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

}
