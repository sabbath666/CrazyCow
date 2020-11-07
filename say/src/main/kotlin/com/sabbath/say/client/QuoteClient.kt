package com.sabbath.say.client

import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

private val logger = KotlinLogging.logger {}

@Component
class QuoteClient(
        private val restTemplate: RestTemplate
) {
    fun getQuote():String {
        val quote = restTemplate.getForObject("http://localhost:8080/getQuote", String::class.java) ?: ""
        logger.debug ("Получили цитату: $quote")
        return quote
    }
}