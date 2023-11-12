package com.pieterv.weatheragain.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pieterv.weatheragain.data.location.LocationClient
import com.pieterv.weatheragain.domain.repository.WeatherRepository
import com.pieterv.weatheragain.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val locationClient: LocationClient,
    private val weatherRepository: WeatherRepository,
) : ViewModel() {

    var state by mutableStateOf(MainScreenState())
        private set

    fun loadWeatherInfo() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)

            locationClient.getCurrentLocation().let { location ->
                //todo handle location loading failures, leaving as is for now
                if (location == null) {
                    state = state.copy(
                        isLoading = false,
                        error = null,
                        data = null,
                        locationFailed = true
                    )
                    return@let
                }
                val result = weatherRepository.getWeatherData(
                    lat = location.latitude,
                    long = location.longitude,
                )

                state = when (result) {
                    is Resource.Success -> {
                        state.copy(
                            isLoading = false,
                            data = result.data,
                            error = null,
                            locationFailed = false
                        )
                    }

                    is Resource.Error -> {
                        state.copy(
                            isLoading = false,
                            data = null,
                            error = result.message,
                            locationFailed = false
                        )
                    }
                }
            }
        }
    }
}