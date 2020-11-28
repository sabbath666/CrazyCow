package com.sabbath.say.client

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

private val logger = KotlinLogging.logger {}

@Component
class QuoteClient(
        private val restTemplate: RestTemplate,
        @Value("\${quote.url}")
        private val quoteUrl:String
) {
    fun getQuote(style:String):String {
        val quote = restTemplate.getForObject("$quoteUrl?style=$style", String::class.java) ?: ""
        logger.debug ("Получили цитату: $quote")
        return quote
    }
}