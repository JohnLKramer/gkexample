package com.example.gkexample.service

import com.example.gkexample.domain.PieRequest
import com.example.gkexample.entities.BakingIngredient
import com.example.gkexample.entities.Butter
import com.example.gkexample.entities.Flour
import com.example.gkexample.entities.Fruit
import com.example.gkexample.entities.Pie
import com.example.gkexample.entities.Sugar
import com.example.gkexample.repository.ButterRepository
import com.example.gkexample.repository.FlourRepository
import com.example.gkexample.repository.PieRepository
import com.example.gkexample.repository.SugarRepository
import org.springframework.stereotype.Service

@Service
class PastryService(
    private val sugarRepository: SugarRepository,
    private val butterRepository: ButterRepository,
    private val flourRepository: FlourRepository,
    private val pieRepository: PieRepository,
    private val fruitService: FruitServiceInterface
) {
    fun getIngredients(type: String): List<BakingIngredient> {
        return when (type) {
            "sugar" -> sugarRepository.findAll()
            "butter" -> butterRepository.findAll()
            "flour" -> flourRepository.findAll()
            "all" -> {
                val ingredients = mutableListOf<BakingIngredient>()
                ingredients.addAll(flourRepository.findAll())
                ingredients.addAll(butterRepository.findAll())
                ingredients.addAll(flourRepository.findAll())
                ingredients
            }
            else -> {
                listOf()
            }
        }
    }

    fun createSugar(sugar: Sugar): Sugar {
        return sugarRepository.save(sugar)
    }

    fun createFlour(flour: Flour): Flour {
        return flourRepository.save(flour)
    }

    fun createButter(butter: Butter): Butter {
        return butterRepository.save(butter)
    }

    fun createPie(pieRequest: PieRequest): Pie {
        val sugarOptional = sugarRepository.findById(pieRequest.sugarId)
        val flourOptional = flourRepository.findById(pieRequest.flourId)
        val butterOptional = butterRepository.findById(pieRequest.butterId)
        val fruit = getFruit(pieRequest.fruitType)

        val pie = Pie(
            name = pieRequest.name,
            sugar = sugarOptional.get(),
            flour = flourOptional.get(),
            butter = butterOptional.get(),
            fruit = fruit,
        )

        return pieRepository.save(pie)
    }

    private fun getFruit(type: String): Fruit? {
        val fruits: List<Fruit> = fruitService.getFruit(type)

        return fruits.firstOrNull()
    }

    fun getPieByName(name: String): Pie {
        return pieRepository.findByName(name)
    }
}
