package com.sabbath.say.client

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

private val logger = KotlinLogging.logger {}

@Component
class MonsterClient(
        private val restTemplate: RestTemplate,
        @Value("\${monster.url}")
        private val monsterUrl: String
) {

    fun sayMessage(message: String): String {

        val uri = UriComponentsBuilder.fromHttpUrl(monsterUrl)
                .queryParam("message", message)
                .encode(Charsets.UTF_8)
                .build().toUri()

        val monster = restTemplate.getForObject(
                uri, String::class.java) ?: ""
        logger.debug("Получили монстра: $monster")
        return monster
    }
}