package com.sabbath.monster.controller

import com.sabbath.monster.service.MonsterService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MonsterController(
        val monsterService: MonsterService
) {

    @GetMapping("/say")
    fun say(@RequestParam message: String) = monsterService.sayMessage(message)


}