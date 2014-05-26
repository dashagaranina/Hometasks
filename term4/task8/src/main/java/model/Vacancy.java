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
 * Time: 0:52
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "vacancy")
public class Vacancy {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "salary")
    int salary;

    @Column(name = "qualification")
    String qualification;

    @Column(name = "vac_text")
    String vacText;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "company_id")
    Company companyId;

     @ManyToMany
     @JoinTable(name = "vacancy_category_fk",
             joinColumns = { @JoinColumn(name = "id") },
             inverseJoinColumns = { @JoinColumn(name = "vacancy_id") })
     List<Category >categories;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "vac_id")
    List<Response> response;

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

    public String getCategories() {
        return categories.toString();
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getvacText() {
        return vacText;
    }

    public void setvacText(String vacText) {
        this.vacText = vacText;
    }

    public Company getcompanyId() {
        return companyId;
    }

    public void setcompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", qualification='" + qualification + '\'' +
                ", vacText='" + vacText + '\'' +
                ", companyId=" + companyId +
                ", categories=" + categories +
                '}';
    }


}
