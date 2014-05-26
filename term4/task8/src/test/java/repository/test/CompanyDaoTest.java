package repository.test;

import config.PersistenceConfig;
import config.SpringDataJPAConfig;
import model.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import repository.CompanyRepository;

import java.sql.SQLException;

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
        PersistenceConfig.class, SpringDataJPAConfig.class})
public class CompanyDaoTest {

    @Autowired
    private CompanyRepository dao;

    private Company createCompany(){
        Company company = new Company();
        company.setLogin("login");
        company.setName("Lolipops");
        return company;
    }

    @Test
    public void testFindAll() throws SQLException{
        Iterable<Company> companies = dao.findAll();
        assertNotNull(companies);
        assertFalse(companies.iterator().hasNext());
        for(Company company: companies){
            assertNotNull(company);
            assertNotNull(company.getId());
        }
    }

    @Test
    public void TestCRUD() throws SQLException {
        Company company = createCompany();
        dao.save(company);
        assertEquals(dao.findOne(company.getId()).getName(), "Lolipops");
        company.setName("KFC");
        dao.save(company);
        assertEquals(dao.findOne(company.getId()).getName(), "KFC");
        dao.delete(company);
        assertNull(dao.findOne(company.getId()));
    }

}
