package com.tankn.bookmanage.DTO;

import javax.persistence.Id;
import java.sql.Date;

public class BookDTO {
    @Id
    private String id;
    private String name;
    private Date date_of_public;
    private String authorName;

    public BookDTO(String id, String name, Date date_of_public, String authorName) {
        this.id = id;
        this.name = name;
        this.date_of_public = date_of_public;
        this.authorName = authorName;
    }

    public BookDTO() {
    }

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
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

}
