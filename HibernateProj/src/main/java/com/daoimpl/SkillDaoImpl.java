package com.daoimpl;

import com.dao.SkillDAO;
import com.entity.Skill;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SkillDaoImpl implements SkillDAO {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Skill findById(int id){
        entityManager.getTransaction().begin();
        Skill skill = entityManager.find(Skill.class, id);
        entityManager.getTransaction().commit();
        return skill;
    }

    public void create(Skill skill){
        entityManager.getTransaction().begin();
        entityManager.persist(skill);
        entityManager.getTransaction().commit();
    }

    public void update(Skill skill){
        entityManager.getTransaction().begin();
        entityManager.merge(skill);
        entityManager.getTransaction().commit();
    }

    public void delete(Skill skill){
        entityManager.getTransaction().begin();
        entityManager.remove(skill);
        entityManager.getTransaction().commit();
    }
}
