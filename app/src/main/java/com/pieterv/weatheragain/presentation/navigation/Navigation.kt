package com.pieterv.weatheragain.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pieterv.weatheragain.presentation.InitialScreen
import com.pieterv.weatheragain.presentation.WeatherViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val initialViewModel: WeatherViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Screen.InitialScreen.route) {
        composable(
            route = Screen.InitialScreen.route
        ) {
            InitialScreen(
                viewModel = initialViewModel
            )
        }
    }
}