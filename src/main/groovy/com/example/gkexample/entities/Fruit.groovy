package com.example.gkexample.entities

import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.MappedSuperclass
import javax.persistence.Table

@Entity
@Table(name = "FRUIT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",
        discriminatorType = DiscriminatorType.STRING)
class Fruit {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id

    @Column(name = "variety")
    String variety

    @Column(name = "flavor")
    String flavor

    @Column(name = "color")
    String color
}
