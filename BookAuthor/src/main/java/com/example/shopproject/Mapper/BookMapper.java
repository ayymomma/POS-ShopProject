package com.example.shopproject.Mapper;
import com.example.shopproject.Model.DTO.Book.BookDTO;
import com.example.shopproject.Model.DTO.Book.PartialBookDTO;
import com.example.shopproject.Model.DTO.Book.PostBookDTO;
import com.example.shopproject.Model.Entity.Book;

public class BookMapper {
    public static BookDTO convertToBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setYear(book.getYear());
        bookDTO.setPublisher(book.getPublisher());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setStock(book.getStock());
        return bookDTO;
    }

    public static Book convertToBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setYear(bookDTO.getYear());
        book.setPublisher(bookDTO.getPublisher());
        book.setGenre(bookDTO.getGenre());
        book.setIsbn(bookDTO.getIsbn());
        book.setTitle(bookDTO.getTitle());
        book.setPrice(bookDTO.getPrice());
        book.setStock(bookDTO.getStock());
        return book;
    }

    public static PartialBookDTO convertToPartialBookDTO(Book book) {
        PartialBookDTO partialBookDTO = new PartialBookDTO();
        partialBookDTO.setIsbn(book.getIsbn());
        partialBookDTO.setTitle(book.getTitle());
        return partialBookDTO;
    }

    public static PostBookDTO convertToPostBookDTO(Book book) {
        PostBookDTO postBookDTO = new PostBookDTO();
        postBookDTO.setYear(book.getYear());
        postBookDTO.setPublisher(book.getPublisher());
        postBookDTO.setGenre(book.getGenre());
        postBookDTO.setTitle(book.getTitle());
        postBookDTO.setPrice(book.getPrice());
        postBookDTO.setStock(book.getStock());
        return postBookDTO;
    }

    public static Book convertToBook(PostBookDTO postBookDTO) {
        Book book = new Book();
        book.setYear(postBookDTO.getYear());
        book.setPublisher(postBookDTO.getPublisher());
        book.setGenre(postBookDTO.getGenre());
        book.setTitle(postBookDTO.getTitle());
        book.setPrice(postBookDTO.getPrice());
        book.setStock(postBookDTO.getStock());
        return book;
    }
}
