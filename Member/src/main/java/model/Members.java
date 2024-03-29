package model;

import java.sql.Date;

public class Members {


    private int id;
    private String name;
    private String surname;
    private String secondName;
    private String address;
    /** Если указать Date вместо String не будет работать read() в ApplicationDemo*/
    private String birthDay;

    /** String -> Date*/
    public String getBirthDay() {
        return birthDay;
    }
    /** this.birthDay = Date.valueOf(birthday)*/
    public void setBirthDay (String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Members" +"\n"
                +"Name = " + name + "\n"
                +"Surname = " + surname + "\n"
                +"SecondName = " + secondName + "\n"
                +"BirthDay = " + birthDay + "\n"
                +"Address = " + address;
    }
}
