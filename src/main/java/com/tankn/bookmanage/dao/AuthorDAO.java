package com.tankn.bookmanage.dao;

import com.tankn.bookmanage.entities.Author;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AuthorDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TanKN");
    private AuthorDAO(){
    }

    public static AuthorDAO instance;

    public static AuthorDAO getInstance() {
        if(instance == null){
            instance = new AuthorDAO();
        }
        return instance;
    }

    public List<Author> getAuthorByName(String name){
        return emf.createEntityManager().createQuery("select a from Author a where a.name like ?1").setParameter(1, name).getResultList();
    }
}
