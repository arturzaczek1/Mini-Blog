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

    private String title;
    @Column(length = 5000)
    private String content;
    @ManyToOne
    private User user;
}
