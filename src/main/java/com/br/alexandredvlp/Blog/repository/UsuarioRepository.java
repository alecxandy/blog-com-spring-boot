package com.br.alexandredvlp.Blog.repository;

import com.br.alexandredvlp.Blog.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByLogin(String login);
}
