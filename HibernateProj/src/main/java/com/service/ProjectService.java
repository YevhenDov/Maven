package com.service;

import com.connect.HibernateUtil;
import com.dao.ProjectDAO;
import com.entity.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProjectService implements ProjectDAO {
    public Project findById(int id){
        return HibernateUtil.getSessionFactory().openSession().get(Project.class, id);
    }

    public void save(Project project){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(project);
        transaction.commit();
        session.close();
    }

    public void update(Project project){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(project);
        transaction.commit();
        session.close();

    }

    public void delete(Project project){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(project);
        transaction.commit();
        session.close();
    }
}
