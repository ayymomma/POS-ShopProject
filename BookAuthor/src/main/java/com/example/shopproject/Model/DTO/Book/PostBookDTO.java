package com.example.shopproject.Model.DTO.Book;

import com.example.shopproject.Model.DTO.DTO;
import lombok.Data;

@Data
public class PostBookDTO implements DTO {
    private String title;
    private String publisher;
    private Integer year;
    private String genre;
    private Integer stock;
    private Integer price;
}
