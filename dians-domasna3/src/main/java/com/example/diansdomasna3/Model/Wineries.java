package com.example.diansdomasna3.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Cascade;

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
