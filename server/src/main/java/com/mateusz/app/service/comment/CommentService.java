package com.mateusz.app.service.comment;

import com.mateusz.app.domain.Comment;
import com.mateusz.app.message.request.CommentRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    void addComment(CommentRequest commentRequest);

    List<Comment> getComments();
}
