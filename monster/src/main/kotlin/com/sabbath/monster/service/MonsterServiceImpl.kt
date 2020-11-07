package com.sabbath.monster.service

import com.github.ricksbrown.cowsay.plugin.CowExecutor
import org.springframework.stereotype.Service

@Service
class MonsterServiceImpl(
        private val cowExecutor: CowExecutor = CowExecutor().apply {
            setHtml(true)
        }
) : MonsterService {
    override fun sayMessage(message: String): String {
        with(cowExecutor) {
            setMessage(message)
            setCowfile(monsters.random())
            return execute()
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