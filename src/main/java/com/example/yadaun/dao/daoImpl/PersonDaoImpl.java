package com.example.yadaun.dao.daoImpl;


import com.example.yadaun.dao.PersonDao;
import com.example.yadaun.entity.Person;
import com.example.yadaun.entity.User;
import com.example.yadaun.sessionFactory.SessionFactoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    @Override
    public boolean addPerson(Person person) {
        boolean isAdded = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(person);
            tx.commit();
            session.close();
            isAdded = true;
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isAdded;
    }

    @Override
    public boolean updatePerson(Person person) {
        boolean isUpdated = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(person);
            tx.commit();
            session.close();
            isUpdated = true;
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isUpdated;
    }

    @Override
    public boolean deletePerson(int id) {
        boolean isDeleted = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Person person = session.load(Person.class, id);
            Transaction tx = session.beginTransaction();
            session.delete(person);
            tx.commit();
            session.close();
            isDeleted = true;
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isDeleted;
    }

    @Override
    public List<Person> showPeople() {
        List<Person> users = null;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Person> cr = cb.createQuery(Person.class);
            Root<Person> root = cr.from(Person.class);
            cr.select(root);
            users = session.createQuery(cr).getResultList();
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return users;
    }

    @Override
    public Person findPersonById(int id) {
        Person person = null;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Person> cr = cb.createQuery(Person.class);
            Root<Person> root = cr.from(Person.class);
            cr.select(root).where(cb.equal(root.get("personId"), id));
            person = session.createQuery(cr).getSingleResult();
            tx.commit();
            session.close();
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return person;
    }
}


