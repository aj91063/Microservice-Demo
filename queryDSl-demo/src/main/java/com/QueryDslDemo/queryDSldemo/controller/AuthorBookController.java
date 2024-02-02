package com.QueryDslDemo.queryDSldemo.controller;

import com.QueryDslDemo.queryDSldemo.dto.AuthorStatistic;
import com.QueryDslDemo.queryDSldemo.entity.Author;
import com.QueryDslDemo.queryDSldemo.entity.Book;
import com.QueryDslDemo.queryDSldemo.service.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rest")
public class AuthorBookController {

    @Autowired
    private AuthorBookService authorBookService;

    @PostMapping("/authors/book")
    public List<Author> saveAuthorsWithBooks(@RequestBody List<Author> authors) {
        return authorBookService.saveAuthorsWithBooks(authors);
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorBookService.getAuthors();
    }

    @GetMapping("/books")
    public List<Book> getALlBooks() {
        return authorBookService.getBooks();
    }

    @GetMapping("/author/{email}")
    public Optional<Author> findAuthorByEmail(@PathVariable String email) {
        return authorBookService.findAuthorByEmail(email);
    }

    @GetMapping("/authorStatistic")
    public List<AuthorStatistic> getAuthorStatistic() {
        return authorBookService.getAuthorStatistic();
    }

    //to avoid N+1 problem in hibernate/jpa
    @GetMapping("/authors/fetchJoin")
    public List<Author> getAuthorsWithFetchJoin() {
        return authorBookService.getAuthorsWithFetchJoin();
    }
}
