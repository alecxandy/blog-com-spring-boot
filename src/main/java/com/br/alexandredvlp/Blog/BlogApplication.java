package com.br.alexandredvlp.Blog;

import com.br.alexandredvlp.Blog.repository.UsuarioRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApplication {

    private UsuarioRepository usuarioRepository;

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
        //System.out.println(new BCryptPasswordEncoder().encode("123"));
    }

}
