package com.sabbath.monster.controller

import com.sabbath.monster.service.MonsterService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.util.*

@RestController
class MonsterController(
        val monsterService: MonsterService
) {

    @GetMapping("/sayMessage")
    fun sayMessage(@RequestParam message: String) = monsterService.sayMessage(message)

    @GetMapping("/sayDate")
    fun sayDate(): String {
        val sf = SimpleDateFormat("HH:mm")
        return monsterService.sayMessage("Ого уже ${sf.format(Date())!!}")
    }
}