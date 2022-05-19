package com.example.gkexample.repository

import com.example.gkexample.entities.Flour
import org.springframework.data.jpa.repository.JpaRepository

interface FlourRepository : JpaRepository<Flour, Long>
