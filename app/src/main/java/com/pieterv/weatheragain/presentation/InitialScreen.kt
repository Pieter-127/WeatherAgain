package com.pieterv.weatheragain.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pieterv.weatheragain.presentation.components.ForecastDisplay
import com.pieterv.weatheragain.presentation.components.WeatherForecast
import com.pieterv.weatheragain.presentation.components.WeatherOverview

@Composable
fun InitialScreen(viewModel: WeatherViewModel) {
    LaunchedEffect(key1 = Unit) {
        viewModel.loadWeatherInfo()
    }
    InitialScreenContent(viewModel.state)
}

@Preview
@Composable
fun InitialScreenPreview() {
    InitialScreenContent(state = MainScreenState(isLoading = true))
}

@Composable
fun InitialScreenContent(state: MainScreenState) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            WeatherOverview(
                state = state,
                backgroundColor = MaterialTheme.colorScheme.primaryContainer
            )
            ForecastDisplay(state = state)
            Spacer(modifier = Modifier.height(8.dp))
            WeatherForecast(state = state)
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        state.error?.let { error ->
            Text(
                text = error,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}