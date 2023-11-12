package com.pieterv.weatheragain.presentation.navigation

sealed class Screen(
    val route: String
) {
    object InitialScreen : Screen("initial_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}