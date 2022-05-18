package com.example.gkexample.controller

import com.example.gkexample.entities.Apple
import com.example.gkexample.entities.Fruit
import com.example.gkexample.entities.Orange
import com.example.gkexample.service.FruitService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fruit")
class FruitController {
    @Autowired
    FruitService fruitService

    @GetMapping(path = "/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Fruit>> getFruit(@PathVariable String type) {
        List<Fruit> fruits = fruitService.getFruit(type)
        return new ResponseEntity<List<Fruit>>(fruits, HttpStatus.OK)
    }

    @PostMapping(path = "/apple", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Apple> createApple(@RequestBody Apple apple) {
        Apple appleCreated = fruitService.createApple(apple)

        return new ResponseEntity<Apple>(appleCreated, HttpStatus.CREATED)
    }

    @PostMapping(path = "/orange", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Orange> createOrange(@RequestBody Orange orange) {
        Orange orangeCreated = fruitService.createOrange(orange)
        return new ResponseEntity<Orange>(orangeCreated, HttpStatus.CREATED)
    }

    @DeleteMapping(path = "/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> deleteFruit(@PathVariable String type) {
        fruitService.deleteFruit(type)
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT)
    }
}
