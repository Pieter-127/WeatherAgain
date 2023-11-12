package com.pieterv.weatheragain.data.mappers

import com.pieterv.weatheragain.data.remote.WeatherDto
import com.pieterv.weatheragain.domain.weather.CurrentDayInfo
import com.pieterv.weatheragain.domain.weather.RecentWeatherInfo
import com.pieterv.weatheragain.domain.weather.WeatherForecastInfo
import com.pieterv.weatheragain.domain.weather.WeatherInfo
import com.pieterv.weatheragain.domain.weather.WeatherType
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val recentWeatherInfo = hourlyWeatherData.time.mapIndexed { index, time ->
        val temperature = hourlyWeatherData.temperatures[index]
        RecentWeatherInfo(
            time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
            temperatureCelsius = temperature
        )
    }

    val now = LocalDateTime.now()
    val currentWeatherData = recentWeatherInfo.first {
        it.time.hour == now.hour

    }
    val dailyWeatherCode = this.dailyWeatherDataDto.weatherCodes.firstOrNull() ?: 0
    val dailyPrecipitationChance =
        (this.dailyWeatherDataDto.dailyPrecipitationChance.firstOrNull() ?: 0).toDouble()
    val dailyMaxTemperature = (this.dailyWeatherDataDto.dailyTemperatureMax.firstOrNull() ?: 0.0)
    val dailyMinTemperature = (this.dailyWeatherDataDto.dailyTemperatureMin.firstOrNull() ?: 0.0)
    val dailyWindMax = (this.dailyWeatherDataDto.dailyWindSpeed.firstOrNull() ?: 0.0)

    val dates = dailyWeatherDataDto.time.drop(1)
    val upcomingWeatherCodes = dailyWeatherDataDto.weatherCodes.drop(1)
    val upcomingMax = dailyWeatherDataDto.dailyTemperatureMax.drop(1)
    val upcomingMin = dailyWeatherDataDto.dailyTemperatureMin.drop(1)

    val weatherForecastInfo = List(dailyWeatherDataDto.time.take(5).size) { index ->
        val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(dates[index])
        val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
        val dayName = if (date != null) dayFormat.format(date) else ""
        WeatherForecastInfo(
            day = dayName,
            weatherType = WeatherType.fromWeatherCode(upcomingWeatherCodes[index]),
            dailyMaxTemperature = upcomingMax[index],
            dailyMinTemperature = upcomingMin[index]
        )
    }
    return WeatherInfo(
        recentWeatherInfo = currentWeatherData,
        currentDayInfo = CurrentDayInfo(
            weatherType = WeatherType.fromWeatherCode(dailyWeatherCode),
            dailyPrecipitationChance = dailyPrecipitationChance,
            dailyMaxTemperature = dailyMaxTemperature,
            dailyMinTemperature = dailyMinTemperature,
            dailyWindMax = dailyWindMax
        ),
        weatherForecast = weatherForecastInfo
    )
}