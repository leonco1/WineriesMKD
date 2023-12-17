package com.example.diansdomasna2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Wineries {
    String Name;
    List<String> wines;
}
