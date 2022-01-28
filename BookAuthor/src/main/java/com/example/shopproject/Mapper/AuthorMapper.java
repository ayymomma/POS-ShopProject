package com.example.shopproject.Mapper;
import com.example.shopproject.Model.DTO.Author.AuthorDTO;
import com.example.shopproject.Model.DTO.Author.PostAuthorDTO;
import com.example.shopproject.Model.Entity.Author;

public class AuthorMapper{
    public static AuthorDTO convertToAuthorDTO(Author author) {
        var authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setLastName(author.getLastName());
        authorDTO.setFirstName(author.getFirstName());
        return authorDTO;
    }

    public static PostAuthorDTO convertToPostAuthorDTO(Author author) {
        var authorDTO = new PostAuthorDTO();
        authorDTO.setFirstName(author.getFirstName());
        authorDTO.setLastName(author.getLastName());
        return authorDTO;
    }

    public static Author convertTOToAuthor(AuthorDTO authorDTO) {
        var author = new Author();
        author.setId(authorDTO.getId());
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        return author;
    }

    public static Author convertToAuthor(PostAuthorDTO postAuthorDTO) {
        var author = new Author();
        author.setFirstName(postAuthorDTO.getFirstName());
        author.setLastName(postAuthorDTO.getLastName());
        return author;
    }

}
