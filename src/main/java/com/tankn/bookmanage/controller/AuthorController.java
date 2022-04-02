package com.tankn.bookmanage.controller;

import com.tankn.bookmanage.entities.Author;
import com.tankn.bookmanage.responsitory.AuthorResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorResponsitory authorResponsitory;

    @GetMapping("/")
    public List<Author> getAll(){
        return authorResponsitory.findAll();
    }

    @GetMapping("/name/{name}")
    public List<Author> getAuthorByName(@PathVariable("name") String name){
        return authorResponsitory.findAllByNameLike("%"+name+"%");
    }

    @GetMapping("/gender/{gender}")
    public List<Author> getAuthorByGender(@PathVariable("gender") Boolean gender){
        return authorResponsitory.findAllByGender(gender);
    }
    @PostMapping("/")
    public Author updateAuthor(@RequestBody Author author){
        Author author1 = authorResponsitory.findAuthorById(author.getId());
        author1.setGender(author.getGender());
        author1.setDate_of_birth(author.getDate_of_birth());
        author1.setName(author.getName());
        authorResponsitory.save(author1);
        authorResponsitory.flush();
        return author1;
    }
    @PostMapping("/create/")
    public Author createAuthor(@RequestBody Author author){
        authorResponsitory.save(author);
        authorResponsitory.flush();
        return author;
    }
    @DeleteMapping("/{authorId}")
    public Author deleteAuthor(@PathVariable("authorId") String authorId){
        Author author = authorResponsitory.findAuthorById(authorId);
        authorResponsitory.delete(author);
        authorResponsitory.flush();
        return author;
    }
}
