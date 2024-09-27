package com.aliozer.joblisting.service;

import com.aliozer.joblisting.model.Post;
import com.aliozer.joblisting.repository.PostRepository;
import com.aliozer.joblisting.repository.SearchRepository;
import com.aliozer.joblisting.request.PostUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final SearchRepository searchRepository;
    private final MongoTemplate mongoTemplate;

    public PostService(PostRepository postRepository, SearchRepository searchRepository,MongoTemplate mongoTemplate) {
        this.postRepository = postRepository;
        this.searchRepository = searchRepository;
        this.mongoTemplate = mongoTemplate;
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

    public void deletePotById(String postId) {
        postRepository.deleteById(postId);
    }

    public Optional<Post> getOnePostById(String postId) {
        return postRepository.findById(postId);
    }


    public Post updateOnePostById(PostUpdateRequest postUpdateRequest,String postId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(postId));
        Update update = new Update();
        if (postUpdateRequest.getProfile() != null) {
            update.set("profile", postUpdateRequest.getProfile());
        }
        if (postUpdateRequest.getDesc() != null) {
            update.set("desc", postUpdateRequest.getDesc());
        }
        if (postUpdateRequest.getExp() > 0) {
            update.set("exp", postUpdateRequest.getExp());
        }
        if (postUpdateRequest.getTechs() != null && postUpdateRequest.getTechs().length > 0) {
            update.set("techs", postUpdateRequest.getTechs());
        }
        mongoTemplate.updateFirst(query,update,Post.class);
        return postRepository.findById(postId).get();
    }
}