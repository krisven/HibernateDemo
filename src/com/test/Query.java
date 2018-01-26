package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Query {
    public static void main(String[] args){
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();

        //get方式是非延迟加载，无论后面的代码是否会访问到属性，马上执行sql语句
        UserEntity userEntity = session.get(UserEntity.class, 2);
        int userId = userEntity.getId();
        String userUser = userEntity.getUsername();
        String userPassword = userEntity.getPassword();
        System.out.println("ID:" + userId);
        System.out.println("Username:" + userUser);
        System.out.println("Password:" + userPassword);

        //load方式是延迟加载，只有属性被访问的时候才会调用sql语句
        UserEntity userEntity1 = session.load(UserEntity.class, 1);
        int userId1 = userEntity1.getId();
        String userUser1 = userEntity1.getUsername();
        String userPassword1 = userEntity1.getPassword();
        System.out.println("ID:" + userId1);
        System.out.println("Username:" + userUser1);
        System.out.println("Password:" + userPassword1);


        session.close();
    }
}
