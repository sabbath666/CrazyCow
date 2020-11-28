package com.sabbath.say

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SayApplication

fun main(args: Array<String>) {
	runApplication<SayApplication>(*args)
}
