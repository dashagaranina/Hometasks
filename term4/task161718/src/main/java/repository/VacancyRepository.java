package repository;

import model.CV;
import model.Vacancy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VacancyRepository extends CrudRepository<Vacancy, Long>, VacancyRepositoryCustom {
    List<Vacancy> findByTitle(String title);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Query("update Vacancy v set v.title = ?2 where v.title LIKE ?1")
    int setNewTitle(String title, String newTitle);

    @Transactional
    @Query(nativeQuery = true, value = "select * from vacancy where category_id=?1")
    Iterable<Vacancy> findByCategory(Long categoryID);

    List<Vacancy> findByTitleStartingWithIgnoreCase(String title);
}
