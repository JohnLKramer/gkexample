package com.example.gkexample.repository

import com.example.gkexample.entities.Orange
import org.springframework.data.jpa.repository.JpaRepository

interface OrangeRepository extends JpaRepository<Orange, Long> {

}
