package com.example.diansdomasna3.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String Surname;
    String username;
    String password;
    String address;
    String Location;
    String Date;

    public User(String name, String surname, String username, String password, String address,String date) {
        this.name = name;
        Surname = surname;
        this.username = username;
        this.password = password;
        this.address = address;
        this.Location="Skopje";
        Date = date;
    }

    public User() {

    }
}
