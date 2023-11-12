package com.pieterv.weatheragain.domain.repository

import com.pieterv.weatheragain.domain.util.Resource
import com.pieterv.weatheragain.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}