package com.example.shopproject.Repository;

import com.example.shopproject.Model.Entity.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AuthorRepository extends CrudRepository<Author, Integer> {
    List<Author> findAllByLastName(String lastName);

    List<Author> findAllByLastNameIsContaining(String lastName);
}
