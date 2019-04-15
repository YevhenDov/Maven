package com.service;

import com.connect.HibernateUtil;
import com.dao.CompanyDAO;
import com.entity.Company;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CompanyService implements CompanyDAO {
    public Company findById(int id){
        return HibernateUtil.getSessionFactory().openSession().get(Company.class, id);
    }

    public void save(Company company){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(company);
        transaction.commit();
        session.close();
    }

    public void update(Company company){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(company);
        transaction.commit();
        session.close();

    }

    public void delete(Company company){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(company);
        transaction.commit();
        session.close();
    }
}
