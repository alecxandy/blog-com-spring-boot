package com.br.alexandredvlp.Blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

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
    @Lob //melhora na performance se o texto for grande
    private String texto;

}
