package com.service;

import com.connect.HibernateUtil;
import com.dao.SkillDAO;
import com.entity.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SkillService implements SkillDAO {
    public Skill findById(int id){
        return HibernateUtil.getSessionFactory().openSession().get(Skill.class, id);
    }

    public void save(Skill skill){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(skill);
        transaction.commit();
        session.close();
    }

    public void update(Skill skill){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(skill);
        transaction.commit();
        session.close();

    }

    public void delete(Skill skill){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(skill);
        transaction.commit();
        session.close();
    }

}
