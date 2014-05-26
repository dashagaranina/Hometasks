package com.springapp.mvc.dao.Impl;

import com.springapp.mvc.dao.CategoryDao;
import com.springapp.mvc.model.Category;
import com.springapp.mvc.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Company: Dasha
 * Date: 01.03.14
 * Time: 1:00
 * To change this template use File | Settings | File Templates.
 */
public class CategoryDaoImpl implements CategoryDao {
    Session session = null;
    public void add (Category category) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally { //есть ли в этом смысл?
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void delete (Category category){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(category);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally {
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update (Category category){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(category);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally {
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Category> findAll () {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Category> category = session.createQuery("from Category").list();
        return category;
    }

    @Override
    public Category findById(Long id) throws SQLException {
        Session session = null;
        Category category = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            category = (Category) session.get(Category.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return category;
    }
}
