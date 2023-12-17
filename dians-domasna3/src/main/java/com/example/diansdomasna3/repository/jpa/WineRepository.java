package com.example.diansdomasna3.repository.jpa;

import com.example.diansdomasna3.Model.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends JpaRepository<Wine,Long> {

}
