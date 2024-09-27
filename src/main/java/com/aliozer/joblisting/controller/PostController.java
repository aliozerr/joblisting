package com.aliozer.joblisting.controller;

import com.aliozer.joblisting.model.Post;
import com.aliozer.joblisting.request.PostUpdateRequest;
import com.aliozer.joblisting.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("posts/id/{postId}")
    public Optional<Post> getOnePostById(@PathVariable String postId){
        return postService.getOnePostById(postId);
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return postService.searchByText(text);
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @DeleteMapping("/posts/{postId}")
    public String deletePost(@PathVariable String postId){
        postService.deletePotById(postId);
        return "Deleted post id -"+postId;
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<?> updatePost(@RequestBody PostUpdateRequest updateRequest, @PathVariable String postId){
        Optional<Post> onePostById = postService.getOnePostById(postId);
        if (onePostById.isEmpty())
            return new ResponseEntity<>("update requested post does not exits id " + postId, HttpStatus.NOT_FOUND);
        Post updated = postService.updateOnePostById(updateRequest, postId);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

}
