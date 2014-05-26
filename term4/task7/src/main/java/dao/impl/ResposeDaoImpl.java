package dao.impl;

import dao.ResponseDao;
import model.Response;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
* Created with IntelliJ IDEA.
* User: Dasha
* Date: 01.03.14
* Time: 1:00
* To change this template use File | Settings | File Templates.
*/

@Repository
public class ResposeDaoImpl extends BaseDaoImpl<Response, Long> implements ResponseDao {


    @Autowired
   public ResposeDaoImpl (SessionFactory sessionFactory){
       super(Response.class, sessionFactory);
   }
}
