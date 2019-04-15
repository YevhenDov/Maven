package com.service;

import com.connect.HibernateUtil;
import com.dao.DeveloperDAO;
import com.entity.Developer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeveloperService implements DeveloperDAO {
    public Developer findById(int id){
        return HibernateUtil.getSessionFactory().openSession().get(Developer.class, id);
    }

    public void save(Developer developer){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(developer);
        transaction.commit();
        session.close();
    }

    public void update(Developer developer){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(developer);
        transaction.commit();
        session.close();

    }

    public void delete(Developer developer){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(developer);
        transaction.commit();
        session.close();
    }
}
