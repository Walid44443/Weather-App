package com.paymob.weather.util

import kotlin.math.roundToInt


object TempConverterUtil {

    fun toRoundedCelsius(celsius: Double): String = "${(celsius).roundToInt()}"

}