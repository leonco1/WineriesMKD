package com.example.diansdomasna2.Model;

import lombok.Data;

@Data
public class User {
    String name;
    String Surname;
    String Username;
        String password;
String address;
String Location;
String Date;

    public User(String name, String surname, String username, String password, String address,String date) {
        this.name = name;
        Surname = surname;
        Username = username;
        this.password = password;
        this.address = address;
        this.Location="Skopje";
        Date = date;
    }
}
