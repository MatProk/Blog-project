package com.mateusz.app.controller;

import com.mateusz.app.domain.Post;
import com.mateusz.app.message.request.PostRequest;
import com.mateusz.app.repository.PostRepository;
import com.mateusz.app.security.services.UserPrinciple;
import com.mateusz.app.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    PostRepository postRepository;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping("/posts")
    public void savePost(@AuthenticationPrincipal UserPrinciple userPrinciple, @RequestBody PostRequest postRequest){
        postService.addPost(userPrinciple, postRequest);
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> getPostById(@PathVariable(value = "id") Long id){
        return postService.GetPostById(id);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable(value = "id") Long id){
        postRepository.deleteById(id);
    }


}
