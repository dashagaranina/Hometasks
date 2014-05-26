package com.springapp.mvc;

public class Contacts {
    private String name;
    private String number;



    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
      this.name = name;
   }
   public String getName() {
      return name;
   }

    @Override
    public String toString() {
        return name +
                "  "+" "+" " + number;
    }


}