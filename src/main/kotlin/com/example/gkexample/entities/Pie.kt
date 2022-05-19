package com.example.gkexample.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "PIE")
class Pie(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = null,

    @Column(name = "name")
    var name: String,

    @ManyToOne
    @JoinColumn(name = "sugar_id", nullable = false, updatable = false)
    var sugar: Sugar,

    @ManyToOne
    @JoinColumn(name = "butter_id", nullable = false, updatable = false)
    var butter: Butter,

    @ManyToOne
    @JoinColumn(name = "flour_id", nullable = false, updatable = false)
    var flour: Flour,

    @ManyToOne
    @JoinColumn(name = "fruit_id", nullable = true, updatable = false)
    var fruit: Fruit?
)
