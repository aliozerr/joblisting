package com.aliozer.joblisting.repository;

import com.aliozer.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
