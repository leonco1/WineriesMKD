//package com.example.diansdomasna2.repository.InMemoryRepository;
//
//import com.example.diansdomasna2.BootStrap.DataHolder;
//import com.example.diansdomasna2.Model.Wineries;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class InMemoryWineryRepository {
//    public List<Wineries> getWineries()
//    {
//        return DataHolder.wineries;
//    }
//    public Wineries FindByName(String name)
//    {
//        return DataHolder.wineries.stream().filter(i->i.getName().equals(name)).findFirst().get();
//    }
//    public List<String> getWines(String name)
//    {
//        return DataHolder.wineries.stream().filter(i->i.getName().equals(name)).findFirst().get().getWines();
//    }
//
//}
