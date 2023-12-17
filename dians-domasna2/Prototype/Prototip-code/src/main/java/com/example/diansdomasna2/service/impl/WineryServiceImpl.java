package com.example.diansdomasna2.service.impl;

import com.example.diansdomasna2.Model.Wineries;
import com.example.diansdomasna2.repository.WineryRepository;
import com.example.diansdomasna2.service.WineryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineryServiceImpl implements WineryService {
    private final WineryRepository wineryRepository;

    public WineryServiceImpl(WineryRepository wineryRepository) {
        this.wineryRepository = wineryRepository;
    }

    @Override
    public List<Wineries> getWineries() {
        return wineryRepository.getWineries();
    }

    @Override
    public Wineries FindByName(String name) {
        return wineryRepository.FindByName(name);
    }

    @Override
    public List<String> getWines(String name) {
       return wineryRepository.getWines(name);
    }
}
