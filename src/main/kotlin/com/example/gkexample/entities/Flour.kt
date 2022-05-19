package com.example.gkexample.entities

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("flour")
class Flour(
    id: Long? = null,
    weight: Float
) : BakingIngredient(id, weight) {
    val name: String = "flour"
}
