package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Query {
    public static void main(String[] args){
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        UserEntity userEntity = session.get(UserEntity.class, 2);
        int userId = userEntity.getId();
        String userUser = userEntity.getUsername();
        String userPassword = userEntity.getPassword();
        System.out.println("ID:" + userId);
        System.out.println("Username:" + userUser);
        System.out.println("Password:" + userPassword);
        session.close();
    }
}
