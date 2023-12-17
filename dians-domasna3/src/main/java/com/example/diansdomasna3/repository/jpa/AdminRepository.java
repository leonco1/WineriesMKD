package com.example.diansdomasna3.repository.jpa;

import com.example.diansdomasna3.Model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Administrator,Long> {
    Optional<Administrator>findByUsername(String username);
    Optional<Administrator> findByUsernameAndPassword(String username,String password);
}
