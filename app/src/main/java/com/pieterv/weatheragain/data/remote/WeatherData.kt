package com.pieterv.weatheragain.data.remote

import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "hourly")
    val hourlyWeatherData: HourlyWeatherDataDto,
    @field:Json(name = "daily")
    val dailyWeatherDataDto: DailyWeatherDataDto
)