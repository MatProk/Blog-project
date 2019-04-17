package com.mateusz.app.service.comment;

import com.mateusz.app.domain.Comment;
import com.mateusz.app.message.request.CommentRequest;
import com.mateusz.app.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void addComment(CommentRequest commentRequest) {


    }

    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }
}
