package com.pieterv.weatheragain.data.remote

import com.squareup.moshi.Json

data class HourlyWeatherDataDto(
    val time: List<String>,
    @field:Json(name = "temperature_2m")
    val temperatures: List<Double>
)
