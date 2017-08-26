package com.chhaichivon.springbootRESTfullhibernate.utils;

import com.chhaichivon.springbootRESTfullhibernate.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/26/2017
 * TIME   : 12:48 PM
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    // hibernate.properties
    private static SessionFactory buildSessionFactory(){
        try{
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class);

            //configuration.addPackage("com.chhaichivon.springbootRESTfullhibernate.models");
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
        }catch(Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("There was an error building the factory.");
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
