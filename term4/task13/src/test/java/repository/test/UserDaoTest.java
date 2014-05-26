package repository.test;


import config.DataSourceConfig;
import config.SpringDataJPAConfig;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import repository.UserRepository;

import java.sql.SQLException;

import static org.junit.Assert.*;


@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        DataSourceConfig.class, SpringDataJPAConfig.class})
public class UserDaoTest {

    @Autowired
    private UserRepository userDao;

    private User createUser() {
        User user = new User();
        user.setLogin("newLogin");
        user.setPassword("1234321");
        user.setName("Polina");
        user.setSurname("Polinina");
        return user;
    }

    @Test
    public void testFindAll() throws SQLException {
        Iterable<User> userList = userDao.findAll();
        assertNotNull(userList);
        assertTrue(userList.iterator().hasNext());
        for (User user : userList) {
            assertNotNull(user);
            assertNotNull(user.getId());
        }
    }

    @Test
    public void testFindByLogin () throws SQLException{
        User user = createUser();
        userDao.save(user);
        assertEquals(userDao.findByLogin("newLogin"), user);
        userDao.delete(user);
    }

    @Test
    public void testCRUD() throws SQLException {
        User user = createUser();
        userDao.save(user);

        assertEquals(userDao.findOne(user.getId()).getName(), "Polina");
        user.setName("Pollianna");
        userDao.save(user);
        assertEquals(userDao.findOne(user.getId()).getName(), "Pollianna");
        userDao.delete(user);
        assertNull(userDao.findOne(user.getId()));
    }
}
