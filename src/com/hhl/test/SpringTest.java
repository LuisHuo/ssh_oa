package com.hhl.test;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static void main(String[] args) throws Exception {
        SpringTest springTest = new SpringTest();
//        ServiceTest serviceTest = (ServiceTest) springTest.ac.getBean("serviceTest");
//        System.out.println("spring");
//        System.out.println(serviceTest);
//        serviceTest.savaTwoUser();
        SessionFactory sessionFactory = (SessionFactory) springTest.ac.getBean("sessionFactory");
        System.out.println(sessionFactory);
    }


}
