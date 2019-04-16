package com.mateusz.app.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 50, min = 5)
    @Column(nullable = false)
    private String title;


    @Length(max = 500, min = 10)
    @Column(nullable = false)
    private String content;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private Collection<Comment> comments;

    public Post() {
    }

    public Post(String title, @NotNull String content) {
        this.title = title;
        this.content = content;
    }

    public Post(String title, @NotNull String content, @NotNull Date createDate, User user) {
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.user = user;
    }
}