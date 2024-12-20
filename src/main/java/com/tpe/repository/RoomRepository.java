package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoomRepository {
    public void save(Room room) {

        private Session session;
        private Transaction transaction;

        //4-c
        public void save(Room room){
            try {
                session = HibernateUtils.getSessionFactory().openSession();
                Transaction t = session.beginTransaction();
                session.save(room);//insert into t_room values
                t.commit();

            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                HibernateUtils.closeSession(session);
            }
        }
    }
}
