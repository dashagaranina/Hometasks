package repository;

import model.Company;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 01.03.14
 * Time: 0:04
 * To change this template use File | Settings | File Templates.
 */
public interface CompanyRepository extends CrudRepository<Company, Long> , CompanyRepositoryCustom{
    @Modifying
    @Query("update Company c set c.login = ?2 where c.login = ?1")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    int updateByLogin(String login, String newLogin);
}
