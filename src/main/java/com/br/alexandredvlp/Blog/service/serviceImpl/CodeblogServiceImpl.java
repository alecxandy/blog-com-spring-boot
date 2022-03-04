package com.br.alexandredvlp.Blog.service.serviceImpl;

import com.br.alexandredvlp.Blog.model.Post;
import com.br.alexandredvlp.Blog.repository.CodeBlogRepository;
import com.br.alexandredvlp.Blog.service.CodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeblogServiceImpl implements CodeblogService {

    @Autowired
    private CodeBlogRepository codeBlogRepository;

    @Override
    public List<Post> findAll() {
        return codeBlogRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return codeBlogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return codeBlogRepository.save(post);
    }
}
