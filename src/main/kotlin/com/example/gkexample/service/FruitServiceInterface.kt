package com.example.gkexample.service

import com.example.gkexample.entities.Fruit

interface FruitServiceInterface {
    fun getFruit(type: String): List<Fruit>
}
