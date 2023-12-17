package com.example.diansdomasna3.repository.jpa;

import com.example.diansdomasna3.Model.Wine;
import com.example.diansdomasna3.Model.Wineries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineriesRepository extends JpaRepository<Wineries,String> {
    Wineries findByName(String name);
    @Query("SELECT w.wines FROM Wineries w WHERE w.name = :name")
    List<Wine> findWinesByWineryName(String name);



}
