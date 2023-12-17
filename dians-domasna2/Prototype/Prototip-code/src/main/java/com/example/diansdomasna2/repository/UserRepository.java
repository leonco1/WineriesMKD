package com.example.diansdomasna2.repository;

import com.example.diansdomasna2.BootStrap.DataHolder;
import com.example.diansdomasna2.Model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    public List<User> Find_All()
    {
        return DataHolder.users;
    }
    public Optional<User> find_By_username(String username)
    {
        return DataHolder.users.stream().filter(i->i.getUsername().equals(username)).findFirst();
    }
    public Optional<User> Authenticate(String username, String password)
    {
        return DataHolder.users.stream().filter(i->i.getUsername().equals(username)&& i.getPassword().equals(password)).findFirst();
    }
    public User Register(String Name,String Surname,String Username,String password,String address,String DateofBirth)
    {
        User u=new User(Name,Surname,Username,password,address, DateofBirth);
    List<User>users=Find_All();
    users.removeIf(i->i.getUsername().equals(u.getUsername()));
    users.add(u);
    return u;
    }
}
