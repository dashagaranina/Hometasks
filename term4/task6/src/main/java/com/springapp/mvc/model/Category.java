package com.springapp.mvc.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 22.02.14
 * Time: 10:15
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    long id;

    @Column(name = "name")
    String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "categories")
    List<Vacancy> vacancyList;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vacancyList=" + vacancyList.toString() +
                '}';
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

    public String getVacancyList() {
        return vacancyList.toString();
    }

    public void setVacancyList(List<Vacancy> vacancyList) {
        this.vacancyList = vacancyList;
    }
}
