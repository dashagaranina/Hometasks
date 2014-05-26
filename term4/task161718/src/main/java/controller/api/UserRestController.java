package controller.api;

import model.User;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;
import viewobject.UserVO;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private UserRepository userRepository;

    @Autowired
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<UserVO> find(@PathVariable Long id){
        User user = userRepository.findOne(id);
        if (user == null) {
            return new ResponseEntity<UserVO>(HttpStatus.NOT_FOUND);
        }
        UserVO result = new DozerBeanMapper().map(user, UserVO.class);
        return new ResponseEntity<UserVO>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public UserVO create(@RequestBody User user){
        return new DozerBeanMapper().map(userRepository.save(user), UserVO.class);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public UserVO update(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        return new DozerBeanMapper().map(userRepository.save(user), UserVO.class);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        userRepository.delete(id);
    }

   @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<UserVO>> findAll () {
        Iterable<User> users = userRepository.findAll();
        if (!users.iterator().hasNext()) {
            return new ResponseEntity<List<UserVO>>(HttpStatus.NOT_FOUND);
        }
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        Iterator<User> iterator = users.iterator();
        List<UserVO> usersVOList = new LinkedList<UserVO>();
        while (iterator.hasNext()) {
            usersVOList.add(dozerBeanMapper.map(iterator.next(), UserVO.class));
        }
        return new ResponseEntity<List<UserVO>>(usersVOList, HttpStatus.OK);
    }
}
