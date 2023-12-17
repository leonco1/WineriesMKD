package com.example.diansdomasna3.service.impl;

import com.example.diansdomasna3.Model.Administrator;
import com.example.diansdomasna3.repository.jpa.AdminRepository;
import com.example.diansdomasna3.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository repository;

    public AdminServiceImpl(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Administrator> listAdmins() {
        return repository.findAll();
    }


    @Override
    public Optional<Administrator> find_By_username(String username) {
        return repository.findByUsername(username);
    }


    @Override
    public Optional<Administrator> Authenticate(String username, String password) {
        return repository.findByUsernameAndPassword(username,password);
    }
}
