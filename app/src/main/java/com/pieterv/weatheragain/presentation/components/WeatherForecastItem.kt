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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pieterv.weatheragain.R
import com.pieterv.weatheragain.domain.weather.WeatherForecastInfo

@Composable
fun WeatherForecastItem(
    weatherForecastInfo: WeatherForecastInfo,
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    textColor: Color = Color.White
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(24.dp),
        modifier = modifier.padding(horizontal = 8.dp)
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = weatherForecastInfo.day,
                color = textColor,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
            Image(
                painter = painterResource(id = weatherForecastInfo.weatherType.iconRes),
                contentDescription = stringResource(id = weatherForecastInfo.weatherType.weatherDescription),
                modifier =
                Modifier
                    .fillMaxWidth(0.6f)
            )
            Text(
                text = stringResource(id = weatherForecastInfo.weatherType.weatherDescription),
                color = textColor,
                fontSize = 20.sp
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column {
                    Icon(
                        Icons.Filled.KeyboardArrowDown,
                        tint = textColor,
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp),
                        contentDescription = stringResource(id = R.string.min_temperature)
                    )
                    Text(
                        text = stringResource(
                            id = R.string.celsius_format,
                            weatherForecastInfo.dailyMinTemperature.toString()
                        ),
                        color = textColor,
                        fontSize = 18.sp
                    )
                }

                Column {
                    Icon(
                        Icons.Filled.KeyboardArrowUp,
                        tint = textColor,
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp),
                        contentDescription = stringResource(id = R.string.max_temperature)
                    )
                    Text(
                        text = stringResource(
                            id = R.string.celsius_format,
                            weatherForecastInfo.dailyMaxTemperature.toString()
                        ),
                        color = textColor,
                        fontSize = 18.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}