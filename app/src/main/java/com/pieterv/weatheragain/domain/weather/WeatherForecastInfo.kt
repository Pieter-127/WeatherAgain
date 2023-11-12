package com.pieterv.weatheragain.domain.weather

data class WeatherForecastInfo(
    val day: String,
    val weatherType: WeatherType,
    val dailyMaxTemperature: Double,
    val dailyMinTemperature: Double,
)
