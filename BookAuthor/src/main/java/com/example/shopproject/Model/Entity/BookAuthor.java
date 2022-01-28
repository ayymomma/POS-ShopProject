package com.example.shopproject.Model.Entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book_author")
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "id_author")
    private Integer idAuthor;

    public BookAuthor() {

    }
    public BookAuthor(String ISBN, Integer IDAUTHOR) {
        this.isbn = ISBN;
        this.idAuthor = IDAUTHOR;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }
}
