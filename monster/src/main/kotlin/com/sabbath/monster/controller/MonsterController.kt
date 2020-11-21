package com.sabbath.monster.controller

import com.sabbath.monster.MonitoringConfig
import com.sabbath.monster.MonsterConfig
import com.sabbath.monster.service.MonsterService
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.util.*

@RestController
class MonsterController(
        val monsterService: MonsterService,
        val monitoringConfig: MonitoringConfig,
        @Value("\${app.name:gg}")
        val name: String
) {

    @GetMapping("/test")
    fun test() = monsterService.sayMessage(name)

    @GetMapping("/sayMessage")
    fun sayMessage(@RequestParam message: String) = monsterService.sayMessage(message)

    @GetMapping("/sayDate")
    fun sayDate(): String {
        monitoringConfig.testCounter().increment()
        val sf = SimpleDateFormat("HH:mm")
        return monsterService.sayMessage("Ого уже ${sf.format(Date())!!}")
    }
}