package repository;

import model.CV;
import model.Vacancy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface VacancyRepository extends CrudRepository<Vacancy, Long>, VacancyRepositoryCustom {
    @Transactional
    @Query("select v from Vacancy v join v.categories c where c.id = ?1")
        //      SELECT * FROM cv, cv_category WHERE ... AND cv_category.category_id=?1
    Iterable<Vacancy> findByCategory(Long categoryID);
}
