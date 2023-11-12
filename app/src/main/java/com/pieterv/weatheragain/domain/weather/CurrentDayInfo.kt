package com.pieterv.weatheragain.domain.weather

data class CurrentDayInfo(
    val weatherType: WeatherType,
    val dailyPrecipitationChance: Double,
    val dailyMaxTemperature: Double,
    val dailyMinTemperature: Double,
    val dailyWindMax: Double,
)
