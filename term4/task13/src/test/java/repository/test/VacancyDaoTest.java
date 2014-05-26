package repository.test;

import config.DataSourceConfig;
import config.SpringDataJPAConfig;
import model.Category;
import model.Company;
import model.Vacancy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import repository.CategoryRepository;
import repository.VacancyRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 03.03.14
 * Time: 16:56
 * To change this template use File | Settings | File Templates.
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        DataSourceConfig.class, SpringDataJPAConfig.class})
public class VacancyDaoTest {
    @Autowired
    VacancyRepository dao;
    @Autowired
    CategoryRepository categoryDao;

    private Vacancy createVacancy () {
        Vacancy vacancy = new Vacancy();
        vacancy.setName("Frezirovschik");
        vacancy.setSalary(12334);
        vacancy.setQualification("smth");
        vacancy.setvacText("smth-smth");
        Company company = new Company();
        company.setName("Company1");
        vacancy.setcompanyId(company);

        Category category = categoryDao.findOne(1L);
        List<Category> categories = new ArrayList<Category>();
        categories.add(category);
        vacancy.setCategories(categories);
        return vacancy;
    }

    @Test
    public void testFindAll() throws SQLException{
        Iterable<Vacancy> vacancies = dao.findAll();
        assertNotNull(vacancies);
        assertTrue(vacancies.iterator().hasNext());
        for(Vacancy vacancy: vacancies){
            assertNotNull(vacancy);
            assertNotNull(vacancy.getId());
        }
    }

    @Test
    public void testFindBySalary () {
        Vacancy vacancy = createVacancy();
        dao.save(vacancy);
        assertEquals(dao.findBySalary(12334), vacancy);
        dao.delete(vacancy);
    }

    @Test
    public void testCRUD() throws SQLException {
        Vacancy vacancy = createVacancy();
        dao.save(vacancy);
        assertEquals(dao.findOne(vacancy.getId()).getName(), "Frezirovschik");
        vacancy.setName("Cooker");
        dao.save(vacancy);
        assertEquals(dao.findOne(vacancy.getId()).getName(), "Cooker");
        dao.delete(vacancy);
        assertNull(dao.findOne(vacancy.getId()));
    }


}
