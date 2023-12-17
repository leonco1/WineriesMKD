package com.example.diansdomasna3.service;

import com.example.diansdomasna3.Model.User;
import com.example.diansdomasna3.Model.Wine;

import java.util.List;
import java.util.Optional;

public interface UserService {
     List<User>  Find_All();
     Optional<User> find_By_username(String username);
    User Register(String Name,String Surname,String Username,String password,String address,String DateofBirth);
    Optional<User> Authenticate(String username, String password);
    Optional<User>editUser(Long id,String address);
}
