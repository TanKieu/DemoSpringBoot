package com.tankn.bookmanage.responsitory;

import com.tankn.bookmanage.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.BitSet;
import java.util.List;

public interface AuthorResponsitory extends JpaRepository<Author, String> {
    @Query("select a from Author a where a.name like ?1")
    List<Author> findAllByNameLike(String name);


    @Query("select a from Author a where a.gender = ?1")
    List<Author> findAllByGender(Boolean gender);

    @Query("select a from Author a where a.id = ?1")
    Author findAuthorById(String id);
}
