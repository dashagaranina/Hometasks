package ru.kpfu.itis.login.dao;

import ru.kpfu.itis.login.model.Credentials;
import ru.kpfu.itis.login.model.Credentials;

import java.util.List;

public interface CredentialsDao {

    public void add(Credentials credentials);

    public void update(Credentials credentials);

    public void delete(Long id);

    public List findAll();

    public Credentials findByPrimaryKey(Long id) ;

    public boolean findPass (String username, String password);

    public String findSalt (String username);

    public String findFio (String username);

    public String findDate (String username);

    public String findLab (String username);

    public  String findGroup (String username);

    public  String findActivity (String username);
}
