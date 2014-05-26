package com.springapp.mvc.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 22.02.14
 * Time: 0:54
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "CV")
public class CV {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    long id;

    @Column(name = "city")
    String city;

    @Column(name = "spec")
    String spec;

    @Column(name = "cv_text")
    String cvText;

    @Column(name = "gender")
    String gender;

    @Column(name = "birth_date")
    Date birthDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User userId;

    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn(name = "cv_id" )
    List<Response> response;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getcvText() {
        return cvText;
    }

    public void setcvText(String cvText) {
        this.cvText = cvText;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirtDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public User getuserId() {
        return userId;
    }

    public void setuserId(User userId) {
        this.userId = userId;
    }


    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "CV{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", spec='" + spec + '\'' +
                ", cvText='" + cvText + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", userId=" + userId +
                '}';
    }
}
