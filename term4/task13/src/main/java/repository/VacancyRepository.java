package repository;

import model.Vacancy;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 01.03.14
 * Time: 0:43
 * To change this template use File | Settings | File Templates.
 */
public interface VacancyRepository extends CrudRepository<Vacancy, Long> {
    Vacancy findBySalary (int salary);
}
