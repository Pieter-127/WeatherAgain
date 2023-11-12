package com.pieterv.weatheragain.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pieterv.weatheragain.R
import com.pieterv.weatheragain.presentation.MainScreenState
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun WeatherOverview(
    state: MainScreenState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    state.data.let {
        if (state.data?.recentWeatherInfo == null) {
            return@let
        } else {
            val recentWeatherInfo = state.data.recentWeatherInfo
            val dailyWeatherInfo = state.data.currentDayInfo
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = backgroundColor
                ),
                shape = RoundedCornerShape(24.dp),
                modifier = modifier.padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(
                            id = R.string.celsius_format,
                            recentWeatherInfo.temperatureCelsius
                        ),
                        fontSize = 48.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(id = dailyWeatherInfo.weatherType.weatherDescription),
                        fontSize = 24.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Column(
                            Modifier.weight(1f),
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.Start
                        ) {
                            WeatherDataDisplay(
                                title = "Max",
                                value = dailyWeatherInfo.dailyMaxTemperature,
                                unit = "",
                                textStyle = TextStyle(color = Color.White),
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            WeatherDataDisplay(
                                title = "Min",
                                value = dailyWeatherInfo.dailyMinTemperature,
                                unit = "",
                                textStyle = TextStyle(color = Color.White),
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            WeatherDataDisplay(
                                title = "Precipitation",
                                value = dailyWeatherInfo.dailyPrecipitationChance,
                                unit = stringResource(R.string.humidity_percentage),
                                textStyle = TextStyle(color = Color.White),
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            WeatherDataDisplay(
                                title = "Wind",
                                value = dailyWeatherInfo.dailyWindMax,
                                unit = stringResource(R.string.km_per_hour),
                                textStyle = TextStyle(color = Color.White),
                            )
                        }
                        Image(
                            painter = painterResource(id = dailyWeatherInfo.weatherType.iconRes),
                            contentDescription = null,
                            modifier = Modifier
                                .width(200.dp)
                                .weight(1f)
                        )
                    }
                    Spacer(Modifier.height(16.dp))
                    Text(
                        text = stringResource(
                            id = R.string.weather_estimate_template,
                            formatTime(recentWeatherInfo.time)
                        ),
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.End),
                        color = Color.White
                    )
                }
            }
        }
    }
}

fun formatTime(time: LocalDateTime, pattern: String = "HH:mm"): String {
    return time.format(
        DateTimeFormatter.ofPattern(pattern)
    )
}