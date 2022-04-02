package com.tankn.bookmanage.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    private String id;
    private String name;
    private Date date_of_public;
    //private String authorName;
    @ManyToOne(optional = false)
    @JoinColumn(name = "authorId", referencedColumnName = "id")
    private Author author;

    //private String authorId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_of_public() {
        return date_of_public;
    }

    public void setDate_of_public(Date date_of_public) {
        this.date_of_public = date_of_public;
    }

    public String getAuthorName() {
        return author.getName();
    }

//    public void setAuthorName(String authorName) {
//        this. = authorName;
//    }

//     public String getAuthorId() {
//        return authorId;
//    }
//
//    public void setAuthorId(String authorId) {
//        this.authorId = authorId;
//    }

    public Book() {
    }

    public Book(String id, String name, Date date_of_public, Author author) {
        this.id = id;
        this.name = name;
        this.date_of_public = date_of_public;
        //this.authorId = author.getId();
        //this.authorName = author.getName();
    }
}
