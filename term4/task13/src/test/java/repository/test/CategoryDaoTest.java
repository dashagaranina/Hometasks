package repository.test;

import config.DataSourceConfig;
import config.SpringDataJPAConfig;
import model.Category;
import model.Vacancy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import repository.CategoryRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 03.03.14
 * Time: 17:13
 * To change this template use File | Settings | File Templates.
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        DataSourceConfig.class, SpringDataJPAConfig.class})
public class CategoryDaoTest {
    @Autowired
    CategoryRepository dao;

    private Category createCategory() {
        Category category = new Category();
        category.setName("Category1");
        Vacancy vacancy = new Vacancy();
        List<Vacancy> vacancies = new ArrayList<Vacancy>();
        vacancies.add(vacancy);
        category.setVacancyList(vacancies);
        return category;
    }

    @Test
    public void testFindAll() throws SQLException {
        Iterable<Category> categories = dao.findAll();
        assertNotNull(categories);
        assertTrue(categories.iterator().hasNext());
        for (Category category : categories) {
            assertNotNull(category);
            assertNotNull(category.getId());
        }
    }


    @Test
    public void testCRUD() throws SQLException {
        Category category = createCategory();
          dao.save(category);
        assertEquals(dao.findOne(category.getId()).getName(), "Category1");
        category.setName("Kazan");
        dao.save(category);
        assertEquals(dao.findOne(category.getId()).getName(), "Kazan");
        dao.delete(category);
        assertNull(dao.findOne(category.getId()));
    }
}
