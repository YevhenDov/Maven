package com.daoimpl;

import com.dao.DeveloperDao;
import com.entity.Developer;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;

public class DeveloperDaoImpl implements DeveloperDao {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private List<Developer> developers = new CopyOnWriteArrayList<>();

    public Optional<Developer> findById(int id) {
        try {
            entityManager.getTransaction().begin();
            Developer developer = entityManager.find(Developer.class, id);
            entityManager.getTransaction().commit();
            Optional<Developer> optionalDeveloper = Optional.of(developer);
            return optionalDeveloper;
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            return Optional.empty();
        }
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

    public List<Developer> findAll() {
        entityManager.getTransaction().begin();
        developers = entityManager.createQuery("SELECT developer FROM Developer developer", Developer.class).getResultList();
        entityManager.getTransaction().commit();
        if (developers == null){
            developers = new CopyOnWriteArrayList<>();
            return developers;
        }
        return developers;
    }
}
