package com.sample.sandyboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SandybootApplication

fun main(args: Array<String>) {
	runApplication<SandybootApplication>(*args)
}
