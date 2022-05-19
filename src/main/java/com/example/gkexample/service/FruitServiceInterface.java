package com.example.gkexample.service;

import com.example.gkexample.entities.Fruit;

import java.util.List;

public interface FruitServiceInterface {
    List<Fruit> getFruit(String type);
}
