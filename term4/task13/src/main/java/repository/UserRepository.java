package repository;


import model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 25.02.14
 * Time: 22:32
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends CrudRepository<User, Long> {
     User findByLogin (String login);
}
