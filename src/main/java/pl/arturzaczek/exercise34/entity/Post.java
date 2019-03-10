package pl.arturzaczek.exercise34.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
@Setter
@Getter
public class Post extends BaseEntity {

    @Column(name = "title", length = 200)
    private String title;
    @Column(name = "post_body", length = 5000)
    private String postBody;
    @ManyToOne
    private User user;
}
