package com.hhl.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ServiceTest {

    @Resource
    private SessionFactory sessionFactory;

    @Transactional
    public void savaTwoUser(){
        Session session = this.sessionFactory.getCurrentSession();
//        session.save(new User());
//        //int a = 1 / 0;
//        session.save(new User());
    }
}
