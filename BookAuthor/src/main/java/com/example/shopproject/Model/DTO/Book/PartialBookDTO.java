package com.example.shopproject.Model.DTO.Book;

import com.example.shopproject.Model.DTO.DTO;
import lombok.Data;

@Data
public class PartialBookDTO implements DTO {

    public String isbn;
    public String title;

}
