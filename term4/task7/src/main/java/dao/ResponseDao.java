package dao;

import model.Response;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 01.03.14
 * Time: 0:44
 * To change this template use File | Settings | File Templates.
 */
public interface ResponseDao extends BaseDao<Response, Long> {
    public  Response findById(Long id) throws SQLException;
}
