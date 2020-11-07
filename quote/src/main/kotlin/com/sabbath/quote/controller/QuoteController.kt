package com.sabbath.quote.controller

import com.sabbath.quote.service.QuoteService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class QuoteController(
        val quoteService: QuoteService
) {
    @GetMapping("/getQuote")
    fun getQuote() = quoteService.getQuote()

}