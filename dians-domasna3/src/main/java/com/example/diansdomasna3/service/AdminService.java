package com.example.diansdomasna3.service;

import com.example.diansdomasna3.Model.Administrator;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<Administrator> listAdmins();
    Optional<Administrator> find_By_username(String username);
    Optional<Administrator> Authenticate(String username, String password);

}
