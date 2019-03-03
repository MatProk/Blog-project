package com.mateusz.app.service.post;

import com.mateusz.app.domain.Post;
import com.mateusz.app.message.request.PostRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {
    void addPost(PostRequest postRequest);

    List<Post> getAllPosts();

    Optional <Post> GetPostById(Long id);
}
