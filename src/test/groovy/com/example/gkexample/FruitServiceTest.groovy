package com.example.gkexample

import com.example.gkexample.entities.Apple
import com.example.gkexample.entities.Fruit
import com.example.gkexample.entities.Orange
import com.example.gkexample.repository.AppleRepository
import com.example.gkexample.repository.OrangeRepository
import com.example.gkexample.service.FruitService
import com.google.common.collect.Lists
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations


import static org.mockito.Mockito.doReturn
import static org.junit.jupiter.api.Assertions.assertTrue
import static org.junit.jupiter.api.Assertions.assertEquals

class FruitServiceTest {
	@Mock
	AppleRepository appleRepository

	@Mock
	OrangeRepository orangeRepository

	AutoCloseable closeMe

	@InjectMocks
	FruitService fruitService

	@BeforeEach
	void setup() {
		closeMe = MockitoAnnotations.openMocks(this)
	}

	@AfterEach
	void teardown() {
		closeMe.close()
	}

	@Test
	void testGetFruit() {
		Apple fuji = new Apple(id: 1, variety: "fuji", flavor: "sweet", color: "red")

		doReturn(Lists.newArrayList(fuji)).when(appleRepository).findAll()

		Orange valencia = new Orange(id: 1, variety: "valencia", flavor: "sweet", color: "orange")

		doReturn(Lists.newArrayList(valencia)).when(orangeRepository).findAll()

		List<Fruit> fruits = fruitService.getFruit("both")

		assertTrue(fruits.contains(valencia))
		assertTrue(fruits.contains(fuji))
		assertEquals(2, fruits.size())
	}

}
