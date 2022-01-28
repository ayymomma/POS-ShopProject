package com.example.shopproject.Model.DTO.Book;

import com.example.shopproject.Model.DTO.DTO;
import lombok.Data;

@Data
public class BookDTO implements DTO {
    private String isbn;
    private String title;
    private String publisher;
    private Integer year;
    private String genre;
    private Integer stock;
    private Integer price;

    @Override
    public String toString() {
        return "BookDTO{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
