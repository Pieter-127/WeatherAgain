package com.pieterv.weatheragain.domain.weather

import java.time.LocalDateTime

data class RecentWeatherInfo(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
)