package com.example.gkexample.repository

import com.example.gkexample.entities.Apple
import org.springframework.data.jpa.repository.JpaRepository

interface AppleRepository extends JpaRepository<Apple, Long> {

}
