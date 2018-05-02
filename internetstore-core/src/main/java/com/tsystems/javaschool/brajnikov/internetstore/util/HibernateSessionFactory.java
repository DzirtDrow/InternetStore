package com.tsystems.javaschool.brajnikov.internetstore.util;

import com.tsystems.javaschool.brajnikov.internetstore.configuration.HibernateConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {


    private static SessionFactory sessionFactory = buildSessionFactory();

    public static synchronized SessionFactory buildSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                    buildSessionFactory();
        }
        return sessionFactory;
    }
//    protected static SessionFactory buildSessionFactory() {
//        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//        SessionFactory session;
//        try {
//            session = configuration.buildSessionFactory();
////        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
////                .configure() // configures settings from hibernate.cfg.xml
////                .build();
//            //sessionFactory  = configuration.buildSessionFactory(builder.build());
//        }
//        catch (Exception e) {
//            System.out.println("--mark 1");
//
//            e.printStackTrace();
//
//            throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
//
//
//        }
//        return session;
//    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}
