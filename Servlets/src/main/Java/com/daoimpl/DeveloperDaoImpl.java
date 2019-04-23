package com.daoimpl;

import com.dao.DeveloperDao;
import com.entity.Developer;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Queue;

public class DeveloperDaoImpl implements DeveloperDao {
    List<Developer> developers;
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Developer findById(int id) {
        try {
            entityManager.getTransaction().begin();
            Developer developer = entityManager.find(Developer.class, id);
            entityManager.getTransaction().commit();
            return developer;
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
        }
        return null;
    }

    public void create(Developer developer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(developer);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void update(Developer developer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(developer);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(Developer developer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(developer);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
        }
    }

    public List<Developer> getAll(){
        entityManager.getTransaction().begin();
        developers = entityManager.createQuery("SELECT developer FROM Developer developer", Developer.class).getResultList();
        entityManager.getTransaction().commit();
        return developers;
    }
}
