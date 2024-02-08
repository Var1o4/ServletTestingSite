package com.example.yadaun.sessionFactory;

import com.example.yadaun.entity.User;
import com.example.yadaun.entity.TestResult;
import com.example.yadaun.entity.Person;
import com.example.yadaun.entity.Test;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor
public class SessionFactoryImpl {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(TestResult.class);
                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(Test.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
