package com.aliozer.joblisting.service;

import com.aliozer.joblisting.model.Post;
import com.aliozer.joblisting.repository.PostRepository;
import com.aliozer.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final SearchRepository searchRepository;

    public PostService(PostRepository postRepository, SearchRepository searchRepository) {
        this.postRepository = postRepository;
        this.searchRepository = searchRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> searchByText(String text) {
        return searchRepository.findByText(text);
    }
}
