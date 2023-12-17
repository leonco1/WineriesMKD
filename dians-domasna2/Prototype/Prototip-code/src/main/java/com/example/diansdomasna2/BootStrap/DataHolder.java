package com.example.diansdomasna2.BootStrap;

import com.example.diansdomasna2.Model.User;
import com.example.diansdomasna2.Model.Wineries;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataHolder {
    public static List<User> users;
    public static List<Wineries>wineries;
    @PostConstruct
    public void init()
    {
        users=new ArrayList<>();
        wineries=new ArrayList<>();
        users.add( new User("Leonid","Trajkoski","leonid.trajkoski","lt","kosta_abrasevik","16.01.2002"));
        users.add(new User("user","Userski","user.2","ut","address","10.02.1999"));
            List<String>list=new ArrayList<>();
            list.add("Merlot");
            list.add("Chianti");
            list.add("Smederevka");
            wineries.add(new Wineries("Tikves",list));
            wineries.add(new Wineries("Stobi",list));
    }

}
