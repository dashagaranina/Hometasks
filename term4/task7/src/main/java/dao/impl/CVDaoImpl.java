package dao.impl;

import model.CV;
import dao.CVDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
* Created with IntelliJ IDEA.
* User: Dasha
* Date: 01.03.14
* Time: 0:44
* To change this template use File | Settings | File Templates.
*/


@Repository
public class CVDaoImpl extends BaseDaoImpl <CV, Integer>  implements CVDao {

    @Autowired
    public CVDaoImpl (SessionFactory sessionFactory){
        super(CV.class, sessionFactory);
    }

}
