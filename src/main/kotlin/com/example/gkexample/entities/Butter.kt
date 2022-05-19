package com.example.gkexample.entities

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("butter")
class Butter(
    id: Long? = null,
    weight: Float
) : BakingIngredient(id, weight) {
    val name: String = "butter"
}
