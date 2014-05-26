package repository.test;

import config.DataSourceConfig;
import config.SpringDataJPAConfig;
import model.CV;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import repository.CVRepository;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.*;

/**
* Created with IntelliJ IDEA.
* User: Dasha
* Date: 01.03.14
* Time: 11:40
* To change this template use File | Settings | File Templates.
*/
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        DataSourceConfig.class, SpringDataJPAConfig.class})
public class CVDaoTest {
    @Autowired
    private CVRepository cvDao;

    private CV createCV() {
        CV cv = new CV();
        cv.setCity("Moscow");
        cv.setcvText("Some text");
        cv.setGender("male");
        Date date = new Date(2333-12-12);
        cv.setBirtDate(date);
        cv.setSpec("Programmer");
        User user = new User();
        user.setName("Ann");
        cv.setuserId(user);
        return cv;
    }

    @Test
    public void testFindAll () throws SQLException {
        Iterable<CV> cvList = cvDao.findAll();
        assertNotNull(cvList);
        assertTrue(cvList.iterator().hasNext());
        for(CV cv: cvList){
            assertNotNull(cv);
            assertNotNull(cv.getId());
        }
    }


    @Test
    public void testCRUD() throws SQLException{
        CV cv = createCV();
        cvDao.save(cv);
        assertEquals(cvDao.findOne(cv.getId()).getCity(), "Moscow");
        cv.setCity("Kazan");
        cvDao.save(cv);
        assertEquals(cvDao.findOne(cv.getId()).getCity(), "Kazan");
        cvDao.delete(cv);
        assertNull(cvDao.findOne(cv.getId()));
    }

}
