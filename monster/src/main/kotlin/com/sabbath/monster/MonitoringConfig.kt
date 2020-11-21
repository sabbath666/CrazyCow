package com.sabbath.monster

import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MonitoringConfig(
        val registry: MeterRegistry
) {

    @Bean
    fun testCounter() = Counter
            .builder("myCounter")
            .description("my test counter")
            .register(registry)
}