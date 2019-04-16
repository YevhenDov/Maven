package com.service;

import com.dao.SkillDAO;
import com.entity.Skill;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SkillService implements SkillDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Skill read(int id){
        entityManager.getTransaction().begin();
        Skill skill = entityManager.find(Skill.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return skill;
    }

    public void create(Skill skill){
        entityManager.getTransaction().begin();
        entityManager.persist(skill);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Skill skill){
        entityManager.getTransaction().begin();
        entityManager.merge(skill);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public void delete(Skill skill){
        entityManager.getTransaction().begin();
        entityManager.remove(skill);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
