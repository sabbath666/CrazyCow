package com.sabbath.say.client

import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import org.springframework.web.util.UriUtils
import java.nio.charset.Charset

private val logger = KotlinLogging.logger {}

@Component
class MonsterClient(
        private val restTemplate: RestTemplate
) {

    fun sayMessage(message: String): String {

        val uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/sayMessage")
                .queryParam("message", message)
                .encode(Charsets.UTF_8)
                .build().toUri()

        val monster = restTemplate.getForObject(
                uri, String::class.java) ?: ""
        logger.debug("Получили монстра: $monster")
        return monster
    }
}