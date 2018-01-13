package com.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class UserEntityTest {
    public static void main(String[] args){
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(3);
        userEntity.setUsername("c");
        userEntity.setPassword("123456");

        Transaction tran = session.beginTransaction();
        session.save(userEntity);
        tran.commit();
        session.close();
    }
}
