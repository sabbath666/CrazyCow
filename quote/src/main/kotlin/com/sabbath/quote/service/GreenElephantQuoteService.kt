package com.sabbath.quote.service

import org.springframework.stereotype.Service

@Service
class GreenElephantQuoteService : QuoteService {
    override fun getQuote() = listOf(
            "Я тебе покушать принес",
            "Шишка встала",
            "Ну будьте вы ж людьми",
            "Курлык-курлык",
            "Ты на лошаде и я на белом коне"
    ).random()
}