package api.fixture;


import model.User;

import java.util.ArrayList;
import java.util.List;

public class RestDataFixture {

    public static String standardUserJSON() {
        return "{\"id\":1,\"name\":\"Александр Семенов\",\"gender\":\"MALE\",\"city\":\"Казань\",\"phone\":\"2121212\",\"email\":\"alex@gmail.com\"}";
    }

    public static List<User> standardUserList(){
        List<User> list = new ArrayList<User>();
        list.add(standardUser());
        list.add(standardUser());
        list.add(standardUser());
        return list;
    }

    public static User standardUser () {
        return new User(1L);
    }

}
