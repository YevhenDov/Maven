package com.daoimpl;

import com.dao.DeveloperDao;
import com.entity.Developer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeveloperDaoImpl implements DeveloperDao {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Developer findById(int id){
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
