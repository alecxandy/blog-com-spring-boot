package com.br.alexandredvlp.Blog.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {

    @Id
    private String login;

    private String nomeCompleto;

    private String senha;


    public Usuario() {
    }

    public Usuario(String login, String nomeCompleto, String senha) {
        this.login = login;
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
    }

    @ManyToMany
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "login"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "nomeRole"))
    private List<Role> roleList;


    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
