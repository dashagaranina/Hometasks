package com.springapp.mvc.dao;


import com.springapp.mvc.model.User;

import java.sql.SQLException;
import java.util.List;

/**
* Created with IntelliJ IDEA.
* User: Dasha
* Date: 01.03.14
* Time: 10:20
* To change this template use File | Settings | File Templates.
// */
public interface BaseDao<T> {

    public  void add(T t);
    public  void delete(T t);
    public  void update(T t);
    public  List<T> findAll();
    public  T findById(Long id) throws SQLException;
}
