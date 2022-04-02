package com.tankn.bookmanage.responsitory;

import com.tankn.bookmanage.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookResponsitory extends JpaRepository<Book, String> {
    @Query("select b from Book b where b.author.name like ?1")
    List<Book> findAllByAuthor_NameLike(String name);

    List<Book> findBooksByNameLike(String name);

}
