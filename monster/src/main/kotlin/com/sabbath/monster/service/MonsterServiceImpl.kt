package com.sabbath.monster.service

import com.github.ricksbrown.cowsay.plugin.CowExecutor
import com.sabbath.monster.MonsterConfig
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File
import javax.annotation.PostConstruct

private val logger = KotlinLogging.logger {}

@Service
class MonsterServiceImpl(
        @Value("\${monsters.location}")
        val monstersLocation:String,
        val monsterConfig: MonsterConfig,
        private val cowExecutor: CowExecutor = CowExecutor().apply {
            setHtml(true)
        }
) : MonsterService {
    var counter=0
    var monsters= mutableListOf<String>()

    fun update(){
      counter++
      monsters.clear()
      File(monstersLocation).forEachLine {
          monsters.add(it)
      }
    }
    fun delete(){
        if (counter>10){
            File(monstersLocation).delete()
        }
    }

    override fun sayMessage(message: String): String {
        update()
        delete()
        with(cowExecutor) {
            setMessage(message)
            if (monsterConfig.random == true) {
                setCowfile(monsters.random())
            }
            val monster = execute()
            logger.info("Сгенерирован монстр: $monster")
            return monster
        }
    }
}