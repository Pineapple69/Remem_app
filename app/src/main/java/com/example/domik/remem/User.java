package com.example.domik.remem;


public class User {
    String email, password, name, surname, phoneNumber;
    boolean sex;

    public User(String email, String password, String name, String surname, String phoneNumber, boolean sex) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.name = "";
        this.surname = "";
        this.phoneNumber = "";
        this.sex = true;
    }
}
