package com.example.gkexample.repository

import com.example.gkexample.entities.Sugar
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SugarRepository : JpaRepository<Sugar, Long>
