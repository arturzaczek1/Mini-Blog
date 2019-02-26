package pl.arturzaczek.exercise34.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table (name = "user")
public class User extends BaseEntity {
    private String email;
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    private String passwordHash;
    @OneToMany (mappedBy = "user")
    private List<Post> postList = new ArrayList<>();
}
