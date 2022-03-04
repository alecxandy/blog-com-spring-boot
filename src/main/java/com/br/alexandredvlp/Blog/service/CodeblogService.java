package com.br.alexandredvlp.Blog.service;

import com.br.alexandredvlp.Blog.model.Post;

import java.util.List;

public interface CodeblogService {

    List<Post> findAll();

    Post findById(Long id);

    Post save(Post post);
}
