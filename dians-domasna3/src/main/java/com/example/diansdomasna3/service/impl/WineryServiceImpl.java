package com.example.diansdomasna3.service.impl;

import com.example.diansdomasna3.Model.Wine;
import com.example.diansdomasna3.Model.Wineries;
import com.example.diansdomasna3.repository.jpa.WineriesRepository;
import com.example.diansdomasna3.service.WineryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineryServiceImpl implements WineryService {
    private final WineriesRepository wineryRepository;

    public WineryServiceImpl(WineriesRepository wineryRepository) {
        this.wineryRepository = wineryRepository;
    }

    @Override
    public List<Wineries> getWineries() {
        return wineryRepository.findAll();
    }

    @Override
    public Wineries FindByName(String name) {
        return wineryRepository.findByName(name);
    }

    @Override
    public List<Wine> getWines(String name) {
        //        return DataHolder.wineries.stream().filter(i->i.getName().equals(name)).findFirst().get().getWines();
        return wineryRepository.findWinesByWineryName(name);
    }
}
