package dao;


import java.sql.SQLException;
import java.util.List;

/**
* Created with IntelliJ IDEA.
* User: Dasha
* Date: 01.03.14
* Time: 10:20
* To change this template use File | Settings | File Templates.
// */
public interface BaseDao<T, K> {

    public  void save(T t);
    public  void delete(T t);
    public  List<T> findAll();
    public  T findById(K id) throws SQLException;
}
