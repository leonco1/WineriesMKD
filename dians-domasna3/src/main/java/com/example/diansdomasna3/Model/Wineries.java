package com.example.diansdomasna3.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Wineries {
    @Id
    String name;
    @OneToMany(mappedBy = "winery",fetch = FetchType.EAGER)
    List<Wine> wines;
    public Wineries() {

    }
}
