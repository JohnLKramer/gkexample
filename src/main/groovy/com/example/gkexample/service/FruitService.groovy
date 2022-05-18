package com.example.gkexample.service

import com.example.gkexample.entities.Apple
import com.example.gkexample.entities.Fruit
import com.example.gkexample.entities.Orange
import com.example.gkexample.repository.AppleRepository
import com.example.gkexample.repository.OrangeRepository
import com.google.common.collect.Lists
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FruitService {
    AppleRepository appleRepository
    OrangeRepository orangeRepository

    @Autowired
    FruitService(AppleRepository appleRepository, OrangeRepository orangeRepository) {
        this.appleRepository = appleRepository
        this.orangeRepository = orangeRepository
    }

    List<Fruit> getFruit(String type) {
        List<Fruit> fruits = Lists.newArrayList()
        switch (type) {
            case "apple":
                List<Apple> apples = appleRepository.findAll()
                fruits.addAll(apples)
                break
            case "orange":
                fruits.addAll(orangeRepository.findAll())
                break
            case "both":
            case "all":
                fruits.addAll(appleRepository.findAll())
                fruits.addAll(orangeRepository.findAll())
                break
        }
        return fruits
    }

    Apple createApple(Apple apple) {
        return appleRepository.saveAndFlush(apple)
    }

    Orange createOrange(Orange orange) {
        return orangeRepository.saveAndFlush(orange)
    }

    void deleteFruit(String type) {
        switch (type) {
            case "apple":
                appleRepository.deleteAll()
                break
            case "orange":
                orangeRepository.deleteAll()
                break
            case "both":
            case "all":
                appleRepository.deleteAll()
                orangeRepository.deleteAll()
                break
        }
    }
}
