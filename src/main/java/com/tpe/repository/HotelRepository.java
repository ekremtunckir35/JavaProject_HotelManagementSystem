package com.tpe.repository;


import com.tpe.config.HibernateUtils;
import com.tpe.domain.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;

//Room,Guest ve Reservation icin servis ve repo classlarini olusturalim
public class HotelRepository {

    private Session session;

       //1.adim  b databae kaydetme

    public void save(Hotel hotel){
        //Db bilgileri gondermek icin session ihtiyacimiz var

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.save(hotel);//inseert into t_hotel values

            t.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }





    }
}
