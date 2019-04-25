package com.daoimpl;

import com.dao.DeveloperDao;
import com.entity.Developer;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class DeveloperDaoImpl implements DeveloperDao {
    private final String QUERY = "SELECT developer FROM Developer developer";

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

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
        List<Developer> developers;

        entityManager.getTransaction().begin();
        developers = entityManager.createQuery(QUERY, Developer.class).getResultList();
        entityManager.getTransaction().commit();
        if (developers == null){
            developers = new CopyOnWriteArrayList<>();
            return developers;
        }
        return developers;
    }
}
