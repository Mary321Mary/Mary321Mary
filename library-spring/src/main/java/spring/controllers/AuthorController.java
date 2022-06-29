package spring.controllers;

import org.springframework.web.bind.annotation.*;
import spring.models.Author;
import spring.service.AuthorService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public List<Author> findAllAuthors() {
        return this.authorService.findAllAuthors();
    }

    @GetMapping("/{name}")
    public List<Author> findAuthorsByNameContaining(@PathVariable String name) {
        return this.authorService.findAuthorsByNameContaining(name);
    }

}
