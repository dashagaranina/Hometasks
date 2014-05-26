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

    public Credentials findPass (String username, String password, Credentials credentials);

    public String findSalt (String username);

    public Credentials findFio (Credentials credentials);

}
