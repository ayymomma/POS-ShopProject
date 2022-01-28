package com.example.shopproject.Model.DTO.Author;

import com.example.shopproject.Model.DTO.DTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostAuthorDTO implements DTO {
    private String firstName;
    private String lastName;
}
