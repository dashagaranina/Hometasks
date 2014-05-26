package com.springapp.mvc.dao;


import com.springapp.mvc.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 25.02.14
 * Time: 22:32
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao extends BaseDao<User>{
    public List findUserSQL ();

}
