package com.tankn.bookmanage.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "author")
public class Author implements Serializable {
    @Id
    private String id;
    private String name;
    private Boolean gender;
    private Date date_of_birth;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author() {
    }

    public Author(String id, String name, Boolean gender, Date date_of_birth) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
