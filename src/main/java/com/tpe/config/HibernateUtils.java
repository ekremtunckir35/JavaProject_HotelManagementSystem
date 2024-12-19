package com.tpe.config;

import com.tpe.domain.Guest;
import com.tpe.domain.Hotel;
import com.tpe.domain.Reservation;
import com.tpe.domain.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.awt.*;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    static {


        try {
            Configuration configuration = new Configuration().configure().
                    addAnnotatedClass(Hotel.class).
                    addAnnotatedClass(Room.class).
                    addAnnotatedClass(Reservation.class).
                    addAnnotatedClass(Guest.class);


            sessionFactory = configuration.buildSessionFactory();

        } catch (Exception e) {
            System.out.println("Initialization of session factory is FAILED!!!");
        }


    }

    //getter
    public static SessionFactory getSessionFactory() {
        return sessionFactory;

    }

        //SF kaparalim
    public static void shutdown() {


        getSessionFactory().close();


    }
    //session kapatma
     public static void closeSession(Session session) {

        if ( session != null && session.isOpen()){
            session.close();
        }

     }

    public static void shutDown() {
    }
}
