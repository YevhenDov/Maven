package com.service;

import com.dao.DeveloperDAO;
import com.entity.Developer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeveloperService implements DeveloperDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Developer read(int id){
        entityManager.getTransaction().begin();
        Developer developer = entityManager.find(Developer.class, id);
        entityManager.getTransaction().commit();
        return developer;
    }

    public void create(Developer developer){
        entityManager.getTransaction().begin();
        entityManager.persist(developer);
        entityManager.getTransaction().commit();
    }

    public void update(Developer developer){
        entityManager.getTransaction().begin();
        entityManager.merge(developer);
        entityManager.getTransaction().commit();
    }

    public void delete(Developer developer){
        entityManager.getTransaction().begin();
        entityManager.remove(developer);
        entityManager.getTransaction().commit();
    }
}
