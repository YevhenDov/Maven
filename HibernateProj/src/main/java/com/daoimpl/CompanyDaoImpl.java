package com.daoimpl;

import com.dao.CompanyDao;
import com.entity.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CompanyDaoImpl implements CompanyDao {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Company findById(int id){
        entityManager.getTransaction().begin();
        Company company = entityManager.find(Company.class, id);
        entityManager.getTransaction().commit();
        return company;
    }

    public void create(Company company){
        entityManager.getTransaction().begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();
    }

    public void update(Company company){
        entityManager.getTransaction().begin();
        entityManager.merge(company);
        entityManager.getTransaction().commit();
    }

    public void delete(Company company){
        entityManager.getTransaction().begin();
        entityManager.remove(company);
        entityManager.getTransaction().commit();
    }
}