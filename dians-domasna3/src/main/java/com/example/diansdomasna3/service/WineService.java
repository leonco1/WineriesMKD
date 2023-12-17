package com.example.diansdomasna3.service;

import com.example.diansdomasna3.Model.Wine;
import com.example.diansdomasna3.Model.Wineries;
import com.example.diansdomasna3.Model.enumerations.WineType;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WineService {
    List<Wine> listWines();
    Optional<Wine>addWine(String name, WineType wineType, int price, LocalDate year, int size, Wineries wineries);
    Optional<Wine> findById(Long id);
    Optional<Wine>editWine(Long id,int price,int size);
    Optional<Wine> deleteWine(Long id);

}
