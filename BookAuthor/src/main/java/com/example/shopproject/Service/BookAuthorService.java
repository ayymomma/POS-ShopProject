package com.example.shopproject.Service;

import com.example.shopproject.Mapper.AuthorMapper;
import com.example.shopproject.Mapper.BookMapper;
import com.example.shopproject.Model.DTO.Author.AuthorDTO;
import com.example.shopproject.Model.DTO.Book.BookDTO;
import com.example.shopproject.Model.Entity.BookAuthor;
import com.example.shopproject.Repository.AuthorRepository;
import com.example.shopproject.Repository.BookAuthorRepository;
import com.example.shopproject.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookAuthorService {

    @Autowired
    private BookAuthorRepository bookAuthorRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<AuthorDTO> GetIdAuthorsForBook(String isbn) {
        List<BookAuthor> bookAuthorsList = bookAuthorRepository.findAllByIsbn(isbn);
        List<AuthorDTO> authorDTOList = new ArrayList<>();

        for (BookAuthor bookAuthor : bookAuthorsList) {
            var author = authorRepository.findById(bookAuthor.getIdAuthor());
            author.ifPresent(value -> authorDTOList.add(AuthorMapper.convertToAuthorDTO(value)));
        }
        return authorDTOList;
    }

    public List<BookDTO> GetAllBooksForAuthor(Integer idAuthor) {
        List<BookAuthor> bookAuthorsList = bookAuthorRepository.findAllByIdAuthor(idAuthor);
        List<BookDTO> bookDTOList = new ArrayList<>();

        for (BookAuthor bookAuthor : bookAuthorsList) {
            var book = bookRepository.findById(bookAuthor.getIsbn());
            book.ifPresent(value -> bookDTOList.add(BookMapper.convertToBookDTO(value)));
        }
        return bookDTOList;
    }

    public List<BookAuthor> GetIsbnsForAuthor(Integer idAuthor) {
        return bookAuthorRepository.findAllByIdAuthor(idAuthor);
    }

    public void PostBookAuthor(BookAuthor bookAuthor) {
        bookAuthorRepository.save(bookAuthor);
    }

    public void DeleteByIsbn(String ISBN) {
        bookAuthorRepository.deleteByIsbn(ISBN);
    }

    public void DeleteByIdAuthor(Integer IDAUTHOR) {
        bookAuthorRepository.deleteByIdAuthor(IDAUTHOR);
    }
}
