package com.sabbath.say

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class SayApplication

fun main(args: Array<String>) {
	runApplication<SayApplication>(*args)
}
