package com.example.diansdomasna3.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    List<Wine> wineList;
    public User(String name, String surname, String username, String password, String address,String date) {
        this.name = name;
        Surname = surname;
        this.username = username;
        this.password = password;
        this.address = address;
        this.Location="Skopje";
        Date = date;
        this.wineList=new ArrayList<>();
    }

    public User() {

    }
}
