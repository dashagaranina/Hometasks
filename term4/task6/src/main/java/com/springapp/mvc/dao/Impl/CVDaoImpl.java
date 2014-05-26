package com.springapp.mvc.dao.Impl;

import com.springapp.mvc.dao.CVDao;
import com.springapp.mvc.model.CV;
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
public class CVDaoImpl implements CVDao {
    Session session = null;
    public void add (CV cv) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cv);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally { //есть ли в этом смысл?
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void delete (CV cv){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cv);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally {
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update (CV cv){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cv);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally {
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<CV> findAll () {
        session = HibernateUtil.getSessionFactory().openSession();
        List<CV> cv = session.createQuery("from CV").list();
        return cv;
    }

    @Override
    public CV findById(Long id) throws SQLException {
        Session session = null;
        CV cv = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            cv = (CV) session.get(CV.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cv;
    }

}
