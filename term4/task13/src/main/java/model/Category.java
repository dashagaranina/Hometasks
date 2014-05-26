package model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

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
    Long id;

    @Column(name = "name")
    String name;

    @ManyToMany(mappedBy = "categories")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Vacancy> vacancyList;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vacancyList=" + vacancyList.toString() +
                '}';
    }


    public Long getId() {

        return id;
    }

    public void setId(Long id) {
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
