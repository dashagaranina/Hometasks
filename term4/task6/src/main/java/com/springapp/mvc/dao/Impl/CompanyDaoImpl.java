package com.springapp.mvc.dao.Impl;

import com.springapp.mvc.dao.CompanyDao;
import com.springapp.mvc.model.Company;
import com.springapp.mvc.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 01.03.14
 * Time: 0:05
 * To change this template use File | Settings | File Templates.
 */
public class CompanyDaoImpl implements CompanyDao {
    Session session = null;

    public void add (Company company) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(company);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally { //есть ли в этом смысл?
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void delete (Company company){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(company);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally {
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update (Company company){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(company);
            session.getTransaction().commit();

        }   catch (Exception e) {
            e.printStackTrace();
        } finally {
            if  (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Company> findAll () {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Company> company = session.createQuery("from Company").list();
        return company;
    }

    @Override
    public Company findById(Long id) throws SQLException {
        Session session = null;
        Company company = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            company = (Company) session.get(Company.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return company;
    }
}
