package com.pieterv.weatheragain.domain.location

import com.pieterv.weatheragain.data.location.LatLongPosition

interface LocationTracker {
    suspend fun getCurrentLocation(): LatLongPosition?
}