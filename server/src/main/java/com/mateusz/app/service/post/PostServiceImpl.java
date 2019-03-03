package com.mateusz.app.service.post;

import com.mateusz.app.domain.Post;
import com.mateusz.app.message.request.PostRequest;
import com.mateusz.app.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;


    @Override
    public void addPost(PostRequest postRequest) {
        postRepository.save(new Post(postRequest.getTitle(), postRequest.getContent(), new Date()));
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> GetPostById(Long id) {
        return postRepository.findById(id);
    }
}
