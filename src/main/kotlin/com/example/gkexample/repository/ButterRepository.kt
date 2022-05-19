package com.example.gkexample.repository

import com.example.gkexample.entities.Butter
import org.springframework.data.jpa.repository.JpaRepository

interface ButterRepository : JpaRepository<Butter, Long>
