package com.service;

import com.dao.CompanyDAO;
import com.entity.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CompanyService implements CompanyDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Company read(int id){
        entityManager.getTransaction().begin();
        Company company = entityManager.find(Company.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return company;
    }

    public void create(Company company){
        entityManager.getTransaction().begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Company company){
        entityManager.getTransaction().begin();
        entityManager.merge(company);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public void delete(Company company){
        entityManager.getTransaction().begin();
        entityManager.remove(company);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}