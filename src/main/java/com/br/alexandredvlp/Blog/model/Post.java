package com.br.alexandredvlp.Blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TB_POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String titulo;

    private String autor;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy")// formato que a data será salva
    private LocalDate data;

    @NotBlank
    private String texto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(getId(), post.getId()) && Objects.equals(getTitulo(), post.getTitulo()) && Objects.equals(getAutor(), post.getAutor()) && Objects.equals(getData(), post.getData()) && Objects.equals(getTexto(), post.getTexto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitulo(), getAutor(), getData(), getTexto());
    }
}
