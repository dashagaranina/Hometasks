package dao.impl;

import model.Company;
import dao.CompanyDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 01.03.14
 * Time: 0:05
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class CompanyDaoImpl extends BaseDaoImpl<Company, Long> implements CompanyDao {

    @Autowired
    public CompanyDaoImpl (SessionFactory sessionFactory){
        super(Company.class, sessionFactory);
    }
}
