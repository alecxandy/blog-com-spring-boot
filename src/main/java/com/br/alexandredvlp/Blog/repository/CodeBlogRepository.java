package com.br.alexandredvlp.Blog.repository;

import com.br.alexandredvlp.Blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeBlogRepository extends JpaRepository<Post, Long> {

}
