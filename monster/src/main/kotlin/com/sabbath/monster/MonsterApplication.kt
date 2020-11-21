package com.sabbath.monster

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties
class MonsterApplication

fun main(args: Array<String>) {
	runApplication<MonsterApplication>(*args)
}
