package com.example.shopproject.Repository;


import com.example.shopproject.Model.Entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,String> {
    List<Book> findAllByGenre(String genre);

    List<Book> findAllByYear(Integer year);

    List<Book> findAllByGenreAndYear(String GEN, Integer AN);
}
