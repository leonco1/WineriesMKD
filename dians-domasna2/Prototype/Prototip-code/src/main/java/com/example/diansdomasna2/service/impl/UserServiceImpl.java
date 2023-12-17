package com.example.diansdomasna2.service.impl;

import com.example.diansdomasna2.Model.User;
import com.example.diansdomasna2.repository.UserRepository;
import com.example.diansdomasna2.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> Find_All() {
        return userRepository.Find_All();
    }

    @Override
    public Optional<User> find_By_username(String username) {
        return userRepository.find_By_username(username);
    }

    @Override
    public User Register(String Name, String Surname, String Username, String password, String address, String DateofBirth) {
        return userRepository.Register(Name,Surname,Username,password,address, DateofBirth);
    }

    @Override
    public Optional<User> Authenticate(String username, String password) {
        return userRepository.Authenticate(username,password);
    }
}
