package com.example.gkexample.entities

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("orange")
class Orange extends Fruit {
    Orange() {
    }
}
