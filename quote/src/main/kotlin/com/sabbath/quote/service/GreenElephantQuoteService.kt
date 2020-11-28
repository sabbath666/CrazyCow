package com.sabbath.quote.service

import com.sabbath.quote.xml.AwfulXml
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct
import javax.xml.bind.JAXBContext

@Service
class GreenElephantQuoteService : QuoteService {
    override fun getQuote() = listOf(
            "Я тебе покушать принес",
            "Шишка встала",
            "Ну будьте вы ж людьми",
            "Курлык-курлык",
            "Ты на лошаде и я на белом коне"
    ).random()

    @PostConstruct
    fun init(){
        val jaxbContext = JAXBContext.newInstance(AwfulXml::class.java)
        jaxbContext.createUnmarshaller()
    }
}