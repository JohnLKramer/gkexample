package com.example.gkexample.repository

import com.example.gkexample.entities.Pie
import org.springframework.data.jpa.repository.JpaRepository

interface PieRepository : JpaRepository<Pie, Long> {
    fun findByName(name: String): Pie
}
