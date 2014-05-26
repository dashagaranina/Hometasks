package model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

/**
* Created with IntelliJ IDEA.
* User: Dasha
* Date: 22.02.14
* Time: 0:42
* To change this template use File | Settings | File Templates.
*/

@Entity
@Table(name="\"user\"")

public class User {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private long id;

    private String login;

    private String password;

    private String name;

    private String surname;


    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id")
    private List<CV> cv;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<CV> getCv() {
        return cv;
    }

    public void setCv(List<CV> cv) {
        this.cv = cv;
    }

}
