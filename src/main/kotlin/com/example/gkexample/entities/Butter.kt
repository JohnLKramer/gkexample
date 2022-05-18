package com.example.gkexample.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "BUTTER")
data class Butter(
    @Column(name = "weight")
    var weight: Float? = null,

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = null,

    @Column(name = "name")
    var name: String = "butter"
) : Ingredient {
    constructor() : this(null, null, "butter")
}
