package com.example.diansdomasna2.service;

import com.example.diansdomasna2.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
     List<User>  Find_All();
     Optional<User> find_By_username(String username);
    User Register(String Name,String Surname,String Username,String password,String address,String DateofBirth);
    Optional<User> Authenticate(String username, String password);
}
