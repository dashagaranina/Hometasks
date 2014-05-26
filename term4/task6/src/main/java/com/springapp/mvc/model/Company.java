package com.springapp.mvc.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 22.02.14
 * Time: 0:50
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="Company")
public class Company {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    long id;

    @Column(name = "name")
    String name;

    @Column(name = "login")
    String login;

    @Column(name = "password")
    String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    List<Vacancy> vacancy;


    public String getVacancy() {
        return vacancy.toString();
    }

    public void setVacancy(List<Vacancy> vacancy) {
        this.vacancy = vacancy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
