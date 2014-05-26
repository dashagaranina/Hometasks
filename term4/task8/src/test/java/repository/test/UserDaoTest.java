package repository.test;


import config.PersistenceConfig;
import config.SpringDataJPAConfig;
import repository.UserRepository;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

import static org.junit.Assert.*;


@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        PersistenceConfig.class, SpringDataJPAConfig.class})
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
        assertFalse(userList.iterator().hasNext());
        for(User user: userList) {
            assertNotNull(user);
            assertNotNull(user.getId());
        }
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
