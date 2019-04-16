package com.mateusz.app.message.response;

import com.mateusz.app.domain.Comment;
import com.mateusz.app.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;

public class PostResponse {

    private Long id;

    private String title;

    private String content;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createDate;

    User user;

    private Collection<Comment> comments;

    public PostResponse(String title, String content, Date createDate, User user, Collection<Comment> comments) {
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.user = user;
        this.comments = comments;
    }

    public PostResponse(String title, String content, Date date, User user) {
    }
}
