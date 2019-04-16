package com.service;

import com.dao.ProjectDAO;
import com.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProjectService implements ProjectDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Project read(int id){
        entityManager.getTransaction().begin();
        Project project = entityManager.find(Project.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return project;
    }

    public void create(Project project){
        entityManager.getTransaction().begin();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Project project){
        entityManager.getTransaction().begin();
        entityManager.merge(project);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Project project){
        entityManager.getTransaction().begin();
        entityManager.remove(project);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
