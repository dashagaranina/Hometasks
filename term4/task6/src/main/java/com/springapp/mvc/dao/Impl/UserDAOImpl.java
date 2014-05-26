package com.springapp.mvc.dao.Impl;

import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.model.User;
import com.springapp.mvc.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 25.02.14
 * Time: 22:34
 * To change this template use File | Settings | File Templates.
 */
public class UserDAOImpl implements UserDao {

    Session session = null;


    public List findUserSQL() {
        session = HibernateUtil.getSessionFactory().openSession();
        List list = session.createSQLQuery("select * from \"user\" where \"name\"='Marusya' ").addEntity(User.class).list();
         return list;
    }

//    public List findUserHQL() {
//        List list = session.createQuery("from User where name='Marusya' ").list();
//        return list;
//    }

    public void add (User user) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally { //есть ли в этом смысл?
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void delete (User user){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally {
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update (User user){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally {
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<User> findAll () {
        session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User").list();
        return users;
    }

    @Override
    public User findById(Long id) throws SQLException {
        Session session = null;
        User user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            user = (User) session.get(User.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }



}

