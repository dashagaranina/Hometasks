package dao.test;

import model.Company;
import config.PersistenceConfig;
import dao.CompanyDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 03.03.14
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        PersistenceConfig.class})
public class CompanyDaoTest {

    @Autowired
    private CompanyDao dao;

    private Company createCompany(){
        Company company = new Company();
        company.setLogin("login");
        company.setName("Lolipops");
        return company;
    }

    @Test
    public void testFindAll() throws SQLException{
        List<Company> companies = dao.findAll();
        assertNotNull(companies);
        assertFalse(companies.isEmpty());
        for(Company company: companies){
            assertNotNull(company);
            assertNotNull(company.getId());
        }
    }

    @Test
    public void TestCRUD() throws SQLException {
        Company company = createCompany();
        dao.save(company);
        assertEquals(dao.findById(company.getId()).getName(), "Lolipops");
        company.setName("KFC");
        dao.save(company);
        assertEquals(dao.findById(company.getId()).getName(), "KFC");
        dao.delete(company);
        assertNull(dao.findById(company.getId()));
    }

}
