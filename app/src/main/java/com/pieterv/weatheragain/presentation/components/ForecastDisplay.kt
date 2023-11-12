package com.pieterv.weatheragain.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pieterv.weatheragain.R
import com.pieterv.weatheragain.presentation.MainScreenState

@Composable
fun ForecastDisplay(state: MainScreenState, modifier: Modifier = Modifier) {
    state.data.let {
        if (it == null) {
            return@let
        }
        Text(
            text = stringResource(id = R.string.forecast),
            fontSize = 26.sp,
            modifier = modifier.padding(start = 16.dp, bottom = 8.dp)
        )
    }
}