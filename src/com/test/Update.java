package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Update {
    public static void main(String[] args){
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        UserEntity userEntity = session.get(UserEntity.class, 2);
        if(userEntity != null){
            userEntity.setPassword("222");
            Transaction tran = session.beginTransaction();
            session.update(userEntity);
            tran.commit();
        }
        session.close();
    }
}
