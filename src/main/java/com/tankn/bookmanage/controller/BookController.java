package com.tankn.bookmanage.controller;

import com.tankn.bookmanage.DTO.BookDTO;
import com.tankn.bookmanage.entities.Book;
import com.tankn.bookmanage.responsitory.BookResponsitory;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookResponsitory bookResponsitory;

    private final ModelMapper mapper = new ModelMapper();

    @GetMapping("/")
    public List<BookDTO> getAll() {
        List<Book> listBook = bookResponsitory.findAll();
        List<BookDTO> list =  mapper.map(listBook, new TypeToken<List<BookDTO>>(){}.getType());
        return list;
    }
    @GetMapping("/authorName/{name}")
    public List<Book> getByAuthorName(@PathVariable("name") String name ) {
        return bookResponsitory.findAllByAuthor_NameLike("%"+name+"%");
    }
    @GetMapping("/name/{name}")
    public List<Book> getByBookName(@PathVariable("name") String name){
        return bookResponsitory.findBooksByNameLike("%"+name+"%");
    }
}
