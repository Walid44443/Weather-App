package com.paymob.weather.util

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


object DateUtil {

    fun dayOfWeek(stringDate: String): String {
        val oldPattern = "yyyy-MM-dd HH:mm:ss"
        val newPattern = "EEEE"

        val oldDateFormat = SimpleDateFormat(oldPattern)
        val oldDate = oldDateFormat.parse(stringDate)

        val locale = Locale("en", "US")
        val newDateFormat = SimpleDateFormat(newPattern, locale)

        val newDate: String = newDateFormat.format(oldDate)
        return newDate
    }

    fun forecastingDateCard(stringDate: String): String {
        val oldPattern = "yyyy-MM-dd HH:mm:ss"
        val newPattern = "MMMM , dd"

        val oldDateFormat = SimpleDateFormat(oldPattern)
        val oldDate = oldDateFormat.parse(stringDate)

        val locale = Locale("en", "US")
        val newDateFormat = SimpleDateFormat(newPattern, locale)

        val newDate: String = newDateFormat.format(oldDate)
        return newDate
    }

    fun todayForecastingHourCard(stringDate: String): String {
        val oldPattern = "yyyy-MM-dd HH:mm:ss"
        val newPattern = "HH:mm"

        val oldDateFormat = SimpleDateFormat(oldPattern)
        val oldDate = oldDateFormat.parse(stringDate)

        val locale = Locale("en", "US")
        val newDateFormat = SimpleDateFormat(newPattern, locale)

        val newDate: String = newDateFormat.format(oldDate)
        return newDate
    }


}