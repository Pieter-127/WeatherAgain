package com.pieterv.weatheragain.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.pieterv.weatheragain.R
import com.pieterv.weatheragain.presentation.MainScreenState

@Composable
fun WeatherForecast(
    modifier: Modifier = Modifier,
    state: MainScreenState,
) {
    state.data.let {
        if (it == null) {
            return@let
        }
        val entries = it.weatherForecast

        LazyRow(modifier = modifier, content = {
            itemsIndexed(entries) { index, weatherData ->
                val forecastColors =
                    LocalContext.current.resources.obtainTypedArray(R.array.forecastColors)
                val color = Color(forecastColors.getColor(index, 0))

                WeatherForecastItem(
                    weatherForecastInfo = weatherData,
                    backgroundColor = color,
                    modifier = Modifier
                        .height(260.dp)
                        .width(200.dp)
                )
                forecastColors.recycle()
            }
        })
    }
}