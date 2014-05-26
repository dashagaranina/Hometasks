package com.springapp.mvc.main;

import com.springapp.mvc.dao.Impl.UserDAOImpl;
import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.model.User;

import java.sql.SQLException;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws SQLException {
        UserDao userDAO = new UserDAOImpl();
       List<User> userList = userDAO.findUserSQL();
        List<User> users = userDAO.findAll();


        System.out.println("SQL "+userList.get(0).getCv());
        for (int i = 0; i < users.size(); i++) {
            System.out.println("find All" + users.get(i));   // не выводит нормально -___-
        }


    }
}