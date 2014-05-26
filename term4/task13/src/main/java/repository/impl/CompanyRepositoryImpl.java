package repository.impl;

import repository.CompanyRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 29.03.14
 * Time: 0:44
 * To change this template use File | Settings | File Templates.
 */
public class CompanyRepositoryImpl implements CompanyRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Long getIdsByLogin(String login) {
        return ((BigInteger)entityManager.createNativeQuery("SELECT id FROM Company WHERE login=?1").
                setParameter(1, login).getSingleResult()).longValue();
    }
}
