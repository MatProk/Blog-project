package com.mateusz.app.service.post;

import com.mateusz.app.domain.Post;
import com.mateusz.app.domain.User;
import com.mateusz.app.message.request.PostRequest;
import com.mateusz.app.message.response.PostResponse;
import com.mateusz.app.repository.PostRepository;
import com.mateusz.app.repository.UserRepository;
import com.mateusz.app.security.services.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public void addPost(@AuthenticationPrincipal UserPrinciple userPrinciple, PostRequest postRequest) {
        User user = userRepository.findByUsername(userPrinciple.getUsername()).get();
        postRepository.save(new Post(postRequest.getTitle(), postRequest.getContent(), new Date(), user));
    }

    @Override
    public List<Post> getAllPosts() {

        return postRepository.findAllByOrderByCreateDateDesc();

    }

    @Override
    public Optional<Post> GetPostById(Long id) {
        return postRepository.findById(id);
    }
}
