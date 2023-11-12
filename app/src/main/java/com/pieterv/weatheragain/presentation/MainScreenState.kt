package com.pieterv.weatheragain.presentation

import com.pieterv.weatheragain.domain.weather.WeatherInfo

data class MainScreenState(
    val data: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val locationFailed: Boolean = false,
)
