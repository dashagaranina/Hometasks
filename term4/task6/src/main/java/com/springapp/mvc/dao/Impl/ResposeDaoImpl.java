package com.springapp.mvc.dao.Impl;

import com.springapp.mvc.dao.ResponseDao;
import com.springapp.mvc.model.Response;
import com.springapp.mvc.model.User;
import com.springapp.mvc.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
* Created with IntelliJ IDEA.
* User: Dasha
* Date: 01.03.14
* Time: 1:00
* To change this template use File | Settings | File Templates.
*/
public class ResposeDaoImpl implements ResponseDao {
    Session session = null;
    public void add (Response response) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(response);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally { //есть ли в этом смысл?
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void delete (Response response){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(response);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally {
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update (Response response){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(response);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally {
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Response> findAll () {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Response> response = session.createQuery("from Response").list();
        return response;
    }

    @Override
    public Response findById(Long id) throws SQLException {
        Session session = null;
        Response response = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            response = (Response) session.get(Response.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return response;
    }
}
