package com.gonzalez.mavenproyecto;

/**
 *
 * @author socom_000
 */
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class DAO1 {
    

    private static final ThreadLocal session = new ThreadLocal();
    private static final SessionFactory sessionFactory;
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public DAO1() {  }

    public static Session getSession() {
          Session session = (Session) DAO1.session.get();
           if (session == null) {
             session = sessionFactory.openSession();
            DAO1.session.set(session);
                  }
    return session;
    }
    
    protected static void begin() {
        getSession().beginTransaction();
    }
    
    protected static void commit() {
        getSession().getTransaction().commit();
    }
    protected static void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch( HibernateException e ) {

        }
        
        try {
            getSession().close();
        } catch( HibernateException e ) {

        }
        DAO1.session.set(null);
    }

    public static void close() {
        getSession().close();
        DAO1.session.set(null);
    }

}
