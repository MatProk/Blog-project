package com.mateusz.app.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
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

    public Post() {
    }

    public Post(String title, @NotNull String content) {
        this.title = title;
        this.content = content;
    }

    public Post(String title, @NotNull String content, @NotNull Date createDate) {
        this.title = title;
        this.content = content;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
//                ", userPost=" + userPost +
                '}';
    }
}
