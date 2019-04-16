package com.mateusz.app.controller;

import com.mateusz.app.domain.Comment;
import com.mateusz.app.domain.Post;
import com.mateusz.app.domain.User;
import com.mateusz.app.message.request.CommentRequest;
import com.mateusz.app.message.request.PostRequest;
import com.mateusz.app.repository.CommentRepository;
import com.mateusz.app.repository.PostRepository;
import com.mateusz.app.repository.UserRepository;
import com.mateusz.app.security.services.UserPrinciple;
import com.mateusz.app.service.comment.CommentService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("posts/{id}/comments")
    public List<Comment> getComments(){






            return commentService.getComments();
    }

    @PostMapping("posts/{id}/comment")
    public void addComment(@RequestBody Comment comment, @PathVariable(value = "id") Long id, @AuthenticationPrincipal UserPrinciple userPrinciple){

        User user = userRepository.findByUsername(userPrinciple.getUsername()).get();
        Post post = postRepository.getOne(id);

        commentRepository.save(new Comment(comment.getBody(), new Date(), post, user));
    }

}
