package com.daoimpl;

import com.dao.DeveloperDao;
import com.entity.Developer;
import lombok.extern.log4j.Log4j;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Log4j
public class DeveloperDaoImpl implements DeveloperDao {
    private static final String QUERY = "SELECT developer FROM Developer developer";

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
            log.error("Developer not founded: " + e.getMessage());
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
            log.error("Developer not created: " + e.getMessage());
        }
    }

    public void update(Developer developer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(developer);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            log.error("Developer not updated: " + e.getMessage());
        }
    }

    public void delete(Developer developer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(developer);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            log.error("Developer not deleted: " + e.getMessage());
        }
    }

    public List<Developer> findAll() {
        List<Developer> developers = new CopyOnWriteArrayList<>();

        try {

            entityManager.getTransaction().begin();
            developers = entityManager.createQuery(QUERY, Developer.class).getResultList();
            entityManager.getTransaction().commit();
            if (developers == null) {
                developers = new CopyOnWriteArrayList<>();
                return developers;
            }
        } catch (NullPointerException e){
            log.error("Developers not founded: " +e.getMessage());
        }
        return developers;
    }
}
