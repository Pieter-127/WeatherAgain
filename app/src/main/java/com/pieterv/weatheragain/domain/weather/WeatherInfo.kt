package com.pieterv.weatheragain.domain.weather

data class WeatherInfo(
    val recentWeatherInfo: RecentWeatherInfo,
    val currentDayInfo: CurrentDayInfo,
    val weatherForecast: List<WeatherForecastInfo>
)