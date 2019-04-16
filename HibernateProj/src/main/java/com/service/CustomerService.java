package com.service;

import com.dao.CustomerDAO;
import com.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CustomerService implements CustomerDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Customer read(int id){
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.getTransaction().commit();
        return customer;
    }

    public void create(Customer customer){
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }

    public void update(Customer customer){
        entityManager.getTransaction().begin();
        entityManager.merge(customer);
        entityManager.getTransaction().commit();
    }

    public void delete(Customer customer){
        entityManager.getTransaction().begin();
        entityManager.remove(customer);
        entityManager.getTransaction().commit();
    }
}
