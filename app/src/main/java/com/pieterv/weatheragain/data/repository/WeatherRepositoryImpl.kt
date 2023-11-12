package com.pieterv.weatheragain.data.repository

import com.pieterv.weatheragain.data.mappers.toWeatherInfo
import com.pieterv.weatheragain.data.remote.WeatherApi
import com.pieterv.weatheragain.domain.repository.WeatherRepository
import com.pieterv.weatheragain.domain.util.Resource
import com.pieterv.weatheragain.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}