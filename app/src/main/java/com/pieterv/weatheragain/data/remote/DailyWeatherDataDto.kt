package com.pieterv.weatheragain.data.remote

import com.squareup.moshi.Json

data class DailyWeatherDataDto(
    val time: List<String>,
    @field:Json(name = "precipitation_probability_max")
    val dailyPrecipitationChance: List<Int>,
    @field:Json(name = "temperature_2m_max")
    val dailyTemperatureMax: List<Double>,
    @field:Json(name = "temperature_2m_min")
    val dailyTemperatureMin: List<Double>,
    @field:Json(name = "wind_speed_10m_max")
    val dailyWindSpeed: List<Double>,
    @field:Json(name = "weathercode")
    val weatherCodes: List<Int>,
)