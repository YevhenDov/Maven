package com.daoimpl;

import com.dao.SkillDAO;
import com.entity.Skill;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SkillDaoImpl implements SkillDAO {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Skill findById(int id) {
        try {
            entityManager.getTransaction().begin();
            Skill skill = entityManager.find(Skill.class, id);
            entityManager.getTransaction().commit();
            return skill;
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
        }
        return null;
    }

    public void create(Skill skill) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(skill);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void update(Skill skill) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(skill);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(Skill skill) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(skill);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
        }
    }
}
