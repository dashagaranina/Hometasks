package dao.impl;

import dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 12.03.14
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */


public class BaseDaoImpl<T,K> implements BaseDao<T,K> {
           private Class<T> type;

        private SessionFactory sessionFactory;

        public BaseDaoImpl(Class<T> type, SessionFactory sessionFactory) {
            this.type = type;
            this.sessionFactory = sessionFactory;
        }

      //TODO почему Serializable?????
        @Override
        public T findById(K id) {
            return (T)getSession().get(type, (Serializable) id);
        }

        @Override
        public void save(T objectToSave) {
            getSession().saveOrUpdate(objectToSave);

        }

        @Override
        public List<T> findAll()  {
            return getSession().createCriteria(type).list();
        }


    @Override
        public void delete(T item)  {
            getSession().delete(item);
        }


    protected Session getSession() {
            return sessionFactory.getCurrentSession();
        }

}

