package repository.test;

import config.DataSourceConfig;
import config.SpringDataJPAConfig;
import model.CV;
import model.RespType;
import model.Response;
import model.Vacancy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import repository.CVRepository;
import repository.ResponseRepository;
import repository.VacancyRepository;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 03.03.14
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */



@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        DataSourceConfig.class, SpringDataJPAConfig.class})
public class ResponseDaoTest {

    @Autowired
    ResponseRepository dao;
    @Autowired
    CVRepository cvDao;

    @Autowired
    VacancyRepository vacancyDao;

    private Response createResponse() throws SQLException {
        Response response = new Response();
        CV cv = cvDao.findOne(1L);
        response.setCv(cv);
        Vacancy vacancy = vacancyDao.findOne(2L);
        response.setVacancy(vacancy);
        response.setType(RespType.INVITE);
        return response;
    }

        @Test
        public void testFindAll () throws SQLException {
            Iterable<Response> all = dao.findAll();
            assertNotNull(all);
            assertTrue(all.iterator().hasNext());
            for(Response response: all){
                assertNotNull(response);
                assertNotNull(response.getType());
            }
        }
    @Test
    public void testCRUD() throws SQLException{
        Response response = createResponse();
        dao.save(response);
        assertEquals(dao.findOne(response.getId()).getType(), RespType.INVITE);
        response.setType(RespType.RESPONSE);
        dao.save(response);
        assertEquals(dao.findOne(response.getId()).getType(), RespType.RESPONSE);
        dao.delete(response);
        assertNull(dao.findOne(response.getId()));
    }
}
