package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {
    public static void main(String[] args){
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        UserEntity userEntity = session.get(UserEntity.class, 3);
        if(userEntity != null){
            Transaction tran = session.beginTransaction();
            session.delete(userEntity);
            tran.commit();
        }
        session.close();
    }
}
