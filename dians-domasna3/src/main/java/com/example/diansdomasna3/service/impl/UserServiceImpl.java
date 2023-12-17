package com.example.diansdomasna3.service.impl;

import com.example.diansdomasna3.Model.User;
import com.example.diansdomasna3.repository.jpa.UserRepository;
import com.example.diansdomasna3.service.UserService;
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
        return userRepository.findAll();
    }

    @Override
    public Optional<User> find_By_username(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User Register(String Name, String Surname, String Username, String password, String address, String DateofBirth) {
        User user = new User(Name,Surname,Username,password,address,DateofBirth);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> Authenticate(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public Optional<User> editUser(Long id,String address) {
        User user=this.userRepository.getReferenceById(id);
        user.setAddress(address);
        this.userRepository.save(user);
        return Optional.of(user);
    }
}
