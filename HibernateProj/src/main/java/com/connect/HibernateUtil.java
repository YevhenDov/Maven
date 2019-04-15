package com.connect;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil(){}

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(com.entity.Developer.class);
                configuration.addAnnotatedClass(com.entity.Project.class);
                configuration.addAnnotatedClass(com.entity.Skill.class);
                configuration.addAnnotatedClass(com.entity.Customer.class);
                configuration.addAnnotatedClass(com.entity.Company.class);
                configuration.configure();

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e){
                throw new ExceptionInInitializerError(e);
            }
        }
        return sessionFactory;
    }
}
