package com.sabbath.say.controller

import com.sabbath.say.client.MonsterClient
import com.sabbath.say.client.QuoteClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SayController(
        val quoteClient: QuoteClient,
        val monsterClient: MonsterClient
) {

    @GetMapping("/say")
    fun say():String {
        val message = quoteClient.getQuote()
        return monsterClient.sayMessage(message)
    }


}

