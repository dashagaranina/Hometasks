package dao.test;

import model.Category;
import model.Vacancy;
import config.PersistenceConfig;
import dao.CategoryDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
        PersistenceConfig.class})
public class CategoryDaoTest {
    @Autowired
    CategoryDao dao;

    private Category createCategory(){
        Category category = new Category();
        category.setName("Category1");
        Vacancy vacancy = new Vacancy();
        List<Vacancy> vacancies = new ArrayList<>();
        vacancies.add(vacancy);
        category.setVacancyList(vacancies);
        return category;
    }

    @Test
    public void testFindAll () throws SQLException {
        List<Category> categories = dao.findAll();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        for(Category category: categories){
            assertNotNull(category);
            assertNotNull(category.getId());
        }
    }


    @Test
    public void testCRUD() throws SQLException{
        Category category = createCategory();
        dao.save(category);
        assertEquals(dao.findById(category.getId()).getName(), "Category1");
        category.setName("Kazan");
        dao.save(category);
        assertEquals(dao.findById(category.getId()).getName(), "Kazan");
        dao.delete(category);
        assertNull(dao.findById(category.getId()));
    }
}