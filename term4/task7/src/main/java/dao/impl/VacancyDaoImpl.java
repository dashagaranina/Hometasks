package dao.impl;

import model.Vacancy;
import dao.VacancyDao;
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
public class VacancyDaoImpl extends BaseDaoImpl<Vacancy, Integer> implements VacancyDao {
    @Autowired
    public VacancyDaoImpl(SessionFactory sessionFactory){
        super(Vacancy.class, sessionFactory);
    }
}
