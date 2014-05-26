package dao.test;

import model.CV;
import model.RespType;
import model.Response;
import model.Vacancy;
import config.PersistenceConfig;
import dao.CVDao;
import dao.ResponseDao;
import dao.VacancyDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

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
        PersistenceConfig.class})
public class ResponseDaoTest {

    @Autowired
    ResponseDao dao;
    @Autowired
    CVDao cvDao;

    @Autowired
    VacancyDao vacancyDao;

    private Response createResponse() throws SQLException {
        Response response = new Response();
        CV cv = cvDao.findById(1);
        response.setCv(cv);
        Vacancy vacancy = vacancyDao.findById(2);
        response.setVacancy(vacancy);
        response.setType(RespType.INVITE);
        return response;
    }

        @Test
        public void testFindAll () throws SQLException {
            List<Response> all = dao.findAll();
            assertNotNull(all);
            for(Response response: all){
                assertNotNull(response);
                assertNotNull(response.getType());
            }
        }
    @Test
    public void testCRUD() throws SQLException{
        Response response = createResponse();
        dao.save(response);
        assertEquals(dao.findById(response.getId()).getType(), RespType.INVITE);
        response.setType(RespType.RESPONSE);
        dao.save(response);
        assertEquals(dao.findById(response.getId()).getType(), RespType.RESPONSE);
        dao.delete(response);
        assertNull(dao.findById(response.getId()));
    }
}
