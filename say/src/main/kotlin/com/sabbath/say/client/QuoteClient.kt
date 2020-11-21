package com.sabbath.say.client

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

private val logger = KotlinLogging.logger {}

@Component
class QuoteClient(
        private val restTemplate: RestTemplate,
        private val discoveryClient: DiscoveryClient,
        @Value("\${quote.url}")
        private val quoteUrl:String
) {
    fun getQuote():String {
        val services = discoveryClient.services
        val quote = restTemplate.getForObject(quoteUrl, String::class.java) ?: ""
        logger.debug ("Получили цитату: $quote")
        return quote
    }
}