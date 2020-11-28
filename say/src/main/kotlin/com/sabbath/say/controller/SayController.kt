package com.sabbath.say.controller

import com.sabbath.say.client.MonsterClient
import com.sabbath.say.client.QuoteClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.util.*
import javax.annotation.PostConstruct

@RestController
class SayController(
        val quoteClient: QuoteClient,
        val monsterClient: MonsterClient
) {

    @PostConstruct
    fun init(){
        println("checking...")
        quoteClient.getQuote(style = "lowerCase")
        monsterClient.sayMessage("test")
        println("ok")
    }

    @GetMapping("/sayQuote")
    fun sayQuote(@RequestParam style: String? = "normal"): String {
        val message = quoteClient.getQuote(style?:"normal")
        val sayMessage = monsterClient.sayMessage(message)
        return sayMessage
    }

    @GetMapping("/sayMessage")
    fun sayMessage(@RequestParam message: String): String {
        return monsterClient.sayMessage(message)
    }

    @GetMapping("/sayDate")
    fun sayDate(): String {
        val sf = SimpleDateFormat("HH:mm")
        return monsterClient.sayMessage("Ого!! Уже ${sf.format(Date())}")
    }


}

