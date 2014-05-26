package ru.kpfu.itis.login.model;

public class Credentials {
    private Long id;
    public String username;
    private String password;
    public String fio;
    public String date;
    public String group;
    public String lab;
    public String activity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFio (){
        return fio;
    }

    public void setFio (String fio){
        this.fio=fio;
    }

    public String getDate() {
         return date;
    }

    public void setDate (String date) {
        this.date=date;
    }

    public String getGroup (){
        return group;
    }

    public void setGroup (String group){
        this.group=group;
    }

    public String getLab (){
        return lab;
    }

    public  void setLab (String lab) {
        this.lab=lab;
    }

    public String getActivity (){
        return activity;
    }

    public void setActivity (String activity){
        this.activity=activity;
    }
}
