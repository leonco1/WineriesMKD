package com.example.diansdomasna2.service;

import com.example.diansdomasna2.Model.Wineries;

import java.util.List;

public interface WineryService {
    public List<Wineries> getWineries();
    public List<String> getWines(String name);
    public Wineries FindByName(String name);

}
