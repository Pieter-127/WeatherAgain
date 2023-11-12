package com.pieterv.weatheragain.domain.weather

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.pieterv.weatheragain.R

sealed class WeatherType(
    @StringRes val weatherDescription: Int,
    @DrawableRes val iconRes: Int
) {
    object ClearSky : WeatherType(
        weatherDescription = R.string.clear_sky,
        iconRes = R.drawable.ic_sunny
    )

    object MainlyClear : WeatherType(
        weatherDescription = R.string.mainly_clear,
        iconRes = R.drawable.ic_cloudy
    )

    object PartlyCloudy : WeatherType(
        weatherDescription = R.string.party_cloudy,
        iconRes = R.drawable.ic_cloudy
    )

    object Overcast : WeatherType(
        weatherDescription = R.string.overcast,
        iconRes = R.drawable.ic_cloudy
    )

    object Foggy : WeatherType(
        weatherDescription = R.string.foggy,
        iconRes = R.drawable.ic_very_cloudy
    )

    object DepositingRimeFog : WeatherType(
        weatherDescription = R.string.depositing_rime_fog,
        iconRes = R.drawable.ic_very_cloudy
    )

    object LightDrizzle : WeatherType(
        weatherDescription = R.string.light_drizzle,
        iconRes = R.drawable.ic_rainshower
    )

    object ModerateDrizzle : WeatherType(
        weatherDescription = R.string.moderate_drizzle,
        iconRes = R.drawable.ic_rainshower
    )

    object DenseDrizzle : WeatherType(
        weatherDescription = R.string.dense_drizzle,
        iconRes = R.drawable.ic_rainshower
    )

    object LightFreezingDrizzle : WeatherType(
        weatherDescription = R.string.light_freezing_drizzle,
        iconRes = R.drawable.ic_snowyrainy
    )

    object DenseFreezingDrizzle : WeatherType(
        weatherDescription = R.string.dense_freezing_drizzle,
        iconRes = R.drawable.ic_snowyrainy
    )

    object SlightRain : WeatherType(
        weatherDescription = R.string.slight_rain,
        iconRes = R.drawable.ic_rainy
    )

    object ModerateRain : WeatherType(
        weatherDescription = R.string.rainy,
        iconRes = R.drawable.ic_rainy
    )

    object HeavyRain : WeatherType(
        weatherDescription = R.string.heavy_rain,
        iconRes = R.drawable.ic_rainy
    )

    object HeavyFreezingRain : WeatherType(
        weatherDescription = R.string.heavy_freezing_rain,
        iconRes = R.drawable.ic_snowyrainy
    )

    object SlightSnowFall : WeatherType(
        weatherDescription = R.string.slight_snow_fall,
        iconRes = R.drawable.ic_snowy
    )

    object ModerateSnowFall : WeatherType(
        weatherDescription = R.string.moderate_snow_fall,
        iconRes = R.drawable.ic_heavysnow
    )

    object HeavySnowFall : WeatherType(
        weatherDescription = R.string.heavy_snow_fall,
        iconRes = R.drawable.ic_heavysnow
    )

    object SnowGrains : WeatherType(
        weatherDescription = R.string.snow_grains,
        iconRes = R.drawable.ic_heavysnow
    )

    object SlightRainShowers : WeatherType(
        weatherDescription = R.string.slight_rain_showers,
        iconRes = R.drawable.ic_rainshower
    )

    object ModerateRainShowers : WeatherType(
        weatherDescription = R.string.moderate_rain_showers,
        iconRes = R.drawable.ic_rainshower
    )

    object ViolentRainShowers : WeatherType(
        weatherDescription = R.string.violent_rain_showers,
        iconRes = R.drawable.ic_rainshower
    )

    object LightSnowShowers : WeatherType(
        weatherDescription = R.string.light_snow_showers,
        iconRes = R.drawable.ic_snowy
    )

    object HeavySnowShowers : WeatherType(
        weatherDescription = R.string.heavy_snow_showers,
        iconRes = R.drawable.ic_snowy
    )

    object ModerateThunderstorm : WeatherType(
        weatherDescription = R.string.moderate_thunderstorm,
        iconRes = R.drawable.ic_thunder
    )

    object SlightHailThunderstorm : WeatherType(
        weatherDescription = R.string.thunderstorm_with_slight_hail,
        iconRes = R.drawable.ic_rainythunder
    )

    object HeavyHailThunderstorm : WeatherType(
        weatherDescription = R.string.thunderstorm_with_heavy_hail,
        iconRes = R.drawable.ic_rainythunder
    )

    companion object {
        fun fromWeatherCode(code: Int): WeatherType {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> LightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}