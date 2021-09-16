package com.walid.weather.util

import kotlin.math.roundToInt


object TempConverterUtil {

    fun toRoundedCelsius(celsius: Double): String = "${(celsius).roundToInt()}"

}