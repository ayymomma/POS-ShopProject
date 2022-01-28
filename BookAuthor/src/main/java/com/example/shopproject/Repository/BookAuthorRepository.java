package com.example.shopproject.Repository;

import com.example.shopproject.Model.Entity.BookAuthor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface BookAuthorRepository extends CrudRepository<BookAuthor, Integer> {
    List<BookAuthor> findAllByIdAuthor(Integer idAuthor);

    List<BookAuthor> findAllByIsbn(String isbn);

    void deleteByIsbn(String isbn);

    void deleteByIdAuthor(Integer idAuthor);
}
