package com.test;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLquery {
    public static void main(String[] args){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        String hql = "from UserEntity ";
        Query query = s.createQuery(hql);
        List list = query.list();
        for(int i = 0; i < list.size(); i++){
            UserEntity userEntity = (UserEntity) list.get(i);
            System.out.println(userEntity.getUsername());
        }

        s.getTransaction().commit();
        s.close();
        sf.close();
    }
}
