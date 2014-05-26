package repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;

public class VacancyRepositoryImpl implements VacancyRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long findId(String title) {
        Query query = entityManager.createNativeQuery("SELECT id from CV WHERE title = ?1");
        query.setParameter(1, title);
        return ((BigInteger)query.getSingleResult()).longValue();
    }
}
