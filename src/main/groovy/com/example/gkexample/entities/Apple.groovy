package com.example.gkexample.entities

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("apple")
class Apple extends Fruit {
    Apple() {
    }
}
