package com.service;

import com.connect.HibernateUtil;
import com.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CustomerService {
    public Customer findById(int id){
        return HibernateUtil.getSessionFactory().openSession().get(Customer.class, id);
    }

    public void save(Customer customer){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    public void update(Customer customer){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();

    }

    public void delete(Customer customer){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(customer);
        transaction.commit();
        session.close();
    }
}
