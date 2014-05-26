package repository;

import model.Company;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 01.03.14
 * Time: 0:04
 * To change this template use File | Settings | File Templates.
 */
public interface CompanyRepository extends CrudRepository<Company, Long> {
}
