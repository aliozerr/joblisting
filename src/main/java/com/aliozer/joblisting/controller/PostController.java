package com.aliozer.joblisting.controller;

import com.aliozer.joblisting.model.Post;
import com.aliozer.joblisting.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/allPosts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return postService.searchByText(text);
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return postService.createPost(post);
    }


}
