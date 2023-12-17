package com.example.diansdomasna3.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String Surname;
    String username;
    String password;


    public Administrator(String name, String surname, String username, String password) {
        this.name = name;
        Surname = surname;
        this.username = username;
        this.password = password;
    }

    public Administrator() {

    }
}
