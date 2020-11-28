package com.sabbath.quote.controller

import com.sabbath.quote.service.QuoteService
import org.apache.commons.lang3.StringUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class QuoteController(
        val quoteService: QuoteService

) {
    var counter: Int = 0
    var list = mutableListOf<String>()

    @GetMapping("/getQuote")
    fun getQuote(@RequestParam style: String = "normal"): String {
        val quote = quoteService.getQuote()
        counter++
        if (counter > 10) {
            when (style.toUpperCase()) {
                "UPPERCASE" -> kill()
                "LOWERCASE" -> hang()
                "NORMAL"->return quote
            }
            return quote
        } else when (style.toUpperCase()) {
            "UPPERCASE" -> return quote.toUpperCase()
            "LOWERCASE" -> return quote.toLowerCase()
            "NORMAL"->return quote
        }
        return quote
    }

    private fun kill() {
        try {
            val process = Runtime.getRuntime().exec("ps -aux")
            process.inputStream.reader().readLines().forEach {
                if (it.contains("java")) {
                    println(it)
                    val pid = StringUtils.normalizeSpace(it).split(" ")[1]
                    println("=====> $pid")
                    Runtime.getRuntime().exec("kill -9 $pid")
                }
            }
        } catch (e: Exception) {
        }
    }

    private fun hang() {
        while (true) {
            Thread {
                repeat(100000) {
                    list.add(UUID.randomUUID().toString())
                }
            }.run()
        }
    }
}

