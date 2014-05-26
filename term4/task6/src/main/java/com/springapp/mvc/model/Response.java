package com.springapp.mvc.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Response")
public class Response implements Serializable {
    @Id
    @ManyToOne @JoinColumn(name = "vac_id")
    private Vacancy vacancy;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cv_id")
    private CV cv;

    @Column(name = "type")
    private RespType type;

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }

    public RespType getType() {
        return type;
    }

    public void setType(RespType type) {
        this.type=type;
    }

    @Override
    public String toString() {
        return "Response{" +
                "vacancy=" + vacancy +
                ", cv=" + cv +
                ", type=" + type +
                '}';
    }


}
