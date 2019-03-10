package pl.arturzaczek.exercise34.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    private String email;
    @Column(name = "first_name", length = 150, unique = true)
    private String firstName;
    @Column(name = "last_name", length = 100)
    private String lastName;
    @Column(name = "password_hash", length = 100)
    private String passwordHash;
    @OneToMany(mappedBy = "user")
    private List<Post> postList = new ArrayList<>();

    @OneToMany
    @JoinTable(name = "user_role")
    private Set<Role> roleSet;

    public void addRole(Role role) {
        if (roleSet == null) {
            roleSet = new HashSet<>();
        }
        roleSet.add(role);
    }

    public User (){
        System.out.println("new user created");
    }
}
