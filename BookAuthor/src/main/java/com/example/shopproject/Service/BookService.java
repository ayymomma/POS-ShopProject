package com.example.shopproject.Service;

import com.example.shopproject.Mapper.BookMapper;
import com.example.shopproject.Model.DTO.Book.BookDTO;
import com.example.shopproject.Model.DTO.Book.PartialBookDTO;
import com.example.shopproject.Model.DTO.Book.PostBookDTO;
import com.example.shopproject.Model.Entity.Book;
import com.example.shopproject.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public BookDTO GetBookByIsbn(String isbn) {
        var book = bookRepository.findById(isbn);
        return book.map(BookMapper::convertToBookDTO).orElse(null);
    }

    public PartialBookDTO GetPartialBookByIsbn(String isbn) {
        var book = bookRepository.findById(isbn);
        return book.map(BookMapper::convertToPartialBookDTO).orElse(null);
    }

    public void PostBook(PostBookDTO postBookDTO) {
        var book = BookMapper.convertToBook(postBookDTO);
        book.setIsbn(UUID.randomUUID().toString());
        bookRepository.save(book);
    }

    public void DeleteBook(String isbn) {
        bookRepository.deleteById(isbn);
    }

    public List<BookDTO> GetAllBooks() {
        List<BookDTO> bookDTOS = new ArrayList<>();
        bookRepository.findAll().forEach(book -> {
            bookDTOS.add(BookMapper.convertToBookDTO(book));
        });
        return bookDTOS;
    }

    public List<BookDTO> GetBooksPerPage(Integer page, Integer itemsPerPage) {
        List<BookDTO> bookList = GetAllBooks();

        if (page < 1)
            page = 1;
        if (itemsPerPage < 1)
            itemsPerPage = 10;
        if (page > (bookList.size() / itemsPerPage))
            if ((bookList.size() % itemsPerPage == 0))
                page = bookList.size() / itemsPerPage;
            else
                page = bookList.size() / itemsPerPage + 1;

        int firstElement = (page - 1) * itemsPerPage;
        int lastElement = page * itemsPerPage - 1;


        if (lastElement >= bookList.size())
            lastElement = bookList.size() - 1;

        return bookList.subList(firstElement, lastElement + 1);
    }

    public List<BookDTO> GetBooksByGenre(String genre) {
        List<BookDTO> bookDTOS = new ArrayList<>();
        bookRepository.findAllByGenre(genre).forEach(book -> {
            bookDTOS.add(BookMapper.convertToBookDTO(book));
        });
        return bookDTOS;
    }

    public List<BookDTO> GetBooksByYear(Integer year) {
        List<BookDTO> bookDTOS = new ArrayList<>();
        bookRepository.findAllByYear(year).forEach(book -> {
            bookDTOS.add(BookMapper.convertToBookDTO(book));
        });
        return bookDTOS;
    }

    public List<BookDTO> GetBooksByGenreAndYear(String genre, Integer year) {
        List<BookDTO> bookDTOS = new ArrayList<>();
        bookRepository.findAllByGenreAndYear(genre, year).forEach(book -> {
            bookDTOS.add(BookMapper.convertToBookDTO(book));
        });
        return bookDTOS;
    }

    public Integer GetStockByISBN(String isbn){
        return GetBookByIsbn(isbn).getStock();
    }

    public void UpdateStockAndPostBook(String isbn, Integer stock){
        var book = GetBookByIsbn(isbn);
        book.setStock(stock);
        bookRepository.save(BookMapper.convertToBook(book));
    }
}
