package com.example.gkexample.entities

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "SUGAR")
class Sugar(
    id: Long? = null,
    weight: Float
) : BakingIngredient(id, weight) {
    val name: String = "sugar"
}
