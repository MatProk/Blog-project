package com.mateusz.app.service.post;

import com.mateusz.app.domain.Post;
import com.mateusz.app.message.request.PostRequest;
import com.mateusz.app.message.response.PostResponse;
import com.mateusz.app.security.services.UserPrinciple;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {
    void addPost(@AuthenticationPrincipal UserPrinciple userPrinciple, PostRequest postRequest);

    List<Post> getAllPosts();

    Optional <Post> GetPostById(Long id);
}
