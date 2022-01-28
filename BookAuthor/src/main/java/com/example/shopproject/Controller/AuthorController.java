package com.example.shopproject.Controller;

import com.example.shopproject.Model.DTO.Author.AuthorDTO;
import com.example.shopproject.Model.DTO.Book.BookDTO;
import com.example.shopproject.Model.DTO.Author.PostAuthorDTO;
import com.example.shopproject.Service.AuthorService;
import com.example.shopproject.Service.BookAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/bookcollection/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @Autowired
    BookAuthorService bookAuthorService;

    @GetMapping
    public @ResponseBody
    AuthorDTO GetAuthorByID(@RequestParam Integer id) {
        return authorService.GetAuthorByID(id);
    }

    @PostMapping
    public void PostAuthor(@RequestBody PostAuthorDTO postAuthorDTO) {
        authorService.PostAuthor(postAuthorDTO);
    }

    @DeleteMapping
    public void DeleteAuthor(@RequestParam Integer id) {
        authorService.DeleteAuthor(id);
    }

    @GetMapping("/all")
    public List<AuthorDTO> GetAllAuthors() {
        return authorService.GetAllAuthors();
    }

    @GetMapping("/{idAuthor}/books")
    public List<BookDTO> GetAllBooksForAuthor(@PathVariable Integer idAuthor) {
        return bookAuthorService.GetAllBooksForAuthor(idAuthor);
    }

    @GetMapping("/find")
    public List<AuthorDTO> GetAllAuthorsByName(
            @RequestParam String lastName,
            @RequestParam(required = false, defaultValue = "") String match) {
        if (Objects.equals(match, "exact"))
            return authorService.GetAuthorByExactLastName(lastName);
        else
            return authorService.GetAuthorByApproximativeLastName(lastName);
    }
}
