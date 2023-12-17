package com.example.diansdomasna3.service;

import com.example.diansdomasna3.Model.Wine;
import com.example.diansdomasna3.Model.Wineries;

import java.util.List;

public interface WineryService {
    public List<Wineries> getWineries();
    public List<Wine> getWines(String name);
    public Wineries FindByName(String name);

}
