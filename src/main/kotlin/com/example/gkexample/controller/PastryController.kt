package com.example.gkexample.controller

import com.example.gkexample.domain.PieRequest
import com.example.gkexample.entities.BakingIngredient
import com.example.gkexample.entities.Butter
import com.example.gkexample.entities.Flour
import com.example.gkexample.entities.Pie
import com.example.gkexample.entities.Sugar
import com.example.gkexample.service.PastryService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pastry")
class PastryController(val pastryService: PastryService) {
    @GetMapping(path = ["/{type}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getBakingIngredients(@PathVariable type: String): ResponseEntity<List<BakingIngredient>> {
        val ingredients: List<BakingIngredient> = pastryService.getIngredients(type)

        return ResponseEntity(ingredients, HttpStatus.OK)
    }

    @PostMapping(
        path = ["/sugar"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createSugar(@RequestBody sugar: Sugar): ResponseEntity<Sugar> {
        val sugarCreated = pastryService.createSugar(sugar)

        return ResponseEntity(sugarCreated, HttpStatus.CREATED)
    }

    @PostMapping(
        path = ["/flour"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createFlour(@RequestBody flour: Flour): ResponseEntity<Flour> {
        val flourCreated = pastryService.createFlour(flour)

        return ResponseEntity(flourCreated, HttpStatus.CREATED)
    }

    @PostMapping(
        path = ["/butter"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createButter(@RequestBody butter: Butter): ResponseEntity<Butter> {
        val butterCreated = pastryService.createButter(butter)

        return ResponseEntity(butterCreated, HttpStatus.CREATED)
    }

    @PostMapping(
        path = ["/pie"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createPie(@RequestBody pieRequest: PieRequest): ResponseEntity<Pie> {
        val pie: Pie = pastryService.createPie(pieRequest)

        return ResponseEntity(pie, HttpStatus.CREATED)
    }

    @GetMapping(path = ["/pie/{name}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getPieByName(@PathVariable name: String): ResponseEntity<Pie> {
        val pie: Pie = pastryService.getPieByName(name)

        return ResponseEntity(pie, HttpStatus.OK)
    }
}
