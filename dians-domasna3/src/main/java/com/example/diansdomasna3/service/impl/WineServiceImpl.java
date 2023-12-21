package com.example.diansdomasna3.service.impl;

import com.example.diansdomasna3.Model.Wine;
import com.example.diansdomasna3.Model.Wineries;
import com.example.diansdomasna3.Model.enumerations.WineType;
import com.example.diansdomasna3.repository.jpa.WineRepository;
import com.example.diansdomasna3.service.WineService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class WineServiceImpl implements WineService {
    private final WineRepository wineRepository;

    public WineServiceImpl(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    @Override
    public List<Wine> listWines() {
        return wineRepository.findAll();
    }

    @Override
    public Optional<Wine> addWine(String name, WineType wineType, int price, LocalDate year, int size, Wineries wineries) {
        Wine wine=new Wine(name,wineType,price,year,size,wineries);
        wineRepository.save(wine);
        return Optional.of(wine);

    }

    @Override
    public Optional<Wine> findById(Long id) {
        return wineRepository.findById(id);
    }

    @Override
    public Optional<Wine> editWine(Long id, int price, int size) {
        Wine wine= this.wineRepository.getReferenceById(id);
            wine.setPrice(price);
            wine.setSize(size);
            this.wineRepository.save(wine);


        return Optional.of(wine);
    }

    @Override
    public void deleteById(Long id) {
        this.wineRepository.deleteById(id);
    }

}
