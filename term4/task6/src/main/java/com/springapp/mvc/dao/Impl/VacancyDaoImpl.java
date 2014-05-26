package com.springapp.mvc.dao.Impl;

import com.springapp.mvc.dao.VacancyDao;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.Vacancy;
import com.springapp.mvc.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
* Created with IntelliJ IDEA.
* User: Dasha
* Date: 01.03.14
* Time: 0:44
* To change this template use File | Settings | File Templates.
*/
public class VacancyDaoImpl implements VacancyDao {
    Session session = null;
    public void add(Vacancy vacancy) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(vacancy);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally { //есть ли в этом смысл?
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void delete (Vacancy vacancy){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(vacancy);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally {
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update (Vacancy vacancy){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(vacancy);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally {
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Vacancy> findAll () {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Vacancy> vacancy = session.createQuery("from Vacancy").list();
        return vacancy;
    }

    @Override
    public Vacancy findById(Long id) throws SQLException {
        Session session = null;
        Vacancy vacancy = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            vacancy= (Vacancy) session.get(Vacancy.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return vacancy;
    }
}
