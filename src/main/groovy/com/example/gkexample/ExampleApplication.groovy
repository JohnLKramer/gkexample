package com.example.gkexample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = [
		"com.example.gkexample.controller",
		"com.example.gkexample.service",
		"com.example.gkexample.repository"
])
class ExampleApplication {
	static void main(String[] args) {
		SpringApplication.run(ExampleApplication, args)
	}
}
