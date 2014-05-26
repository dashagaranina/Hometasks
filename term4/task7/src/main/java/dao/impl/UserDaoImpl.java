package dao.impl;

import model.User;
import dao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 25.02.14
 * Time: 22:34
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(User.class, sessionFactory);
    }

}

