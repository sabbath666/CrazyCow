package com.sabbath.monster.service

import com.github.ricksbrown.cowsay.plugin.CowExecutor
import com.sabbath.monster.MonsterConfig
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class MonsterServiceImpl(
        val monsterConfig: MonsterConfig,
//        @Value("\${monster.random:false}")
//        private val randomMode: Boolean = false,
        private val cowExecutor: CowExecutor = CowExecutor().apply {
            setHtml(true)
        }
) : MonsterService {
    override fun sayMessage(message: String): String {
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

val monsters = listOf(
        "bearface",
        "beavis.zen",
        "bud-frogs",
        "bunny",
        "cat",
        "catfence",
        "charizardvice",
        "cheese",
        "cower",
        "cowfee",
        "daemon",
        "default",
        "dragon-and-cow",
        "dragon",
        "elephant-in-snake",
        "elephant",
        "eyes",
        "fence",
        "flaming-sheep",
        "ghostbusters",
        "goat",
        "hellokitty",
        "hippie",
        "hiya",
        "hypno",
        "kitty",
        "koala",
        "kosh",
        "lamb",
        "adding s",
        "lamb2",
        "adding s",
        "luke-koala",
        "mech-and-cow",
        "meow",
        "milk",
        "minotaur",
        "moofasa",
        "mooghidjirah",
        "moojira",
        "moose",
        "mutilated",
        "psychiatrichelp",
        "adding s",
        "ren",
        "roflcopter",
        "satanic",
        "sheep",
        "shrug",
        "skeleton",
        "small",
        "snoopy",
        "snoopyhouse",
        "snoopysleep",
        "spidercow",
        "stegosaurus",
        "stimpy",
        "supermilker",
        "surgery",
        "tableflip",
        "adding s",
        "three-eyes",
        "turkey",
        "turtle",
        "tux",
        "udder",
        "www"
)