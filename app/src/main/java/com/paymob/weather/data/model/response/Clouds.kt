package com.paymob.weather.data.model.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName
import com.paymob.weather.data.model.response.Coord
import com.paymob.weather.data.model.response.City
import com.paymob.weather.data.model.response.CityWeather
import com.paymob.weather.data.model.response.WeatherItem
import com.paymob.weather.data.model.response.Clouds
import com.paymob.weather.data.model.response.Sys
import com.paymob.weather.data.model.response.Wind
import java.io.Serializable
@Parcelize
data class Clouds(
    @SerializedName("all")
    var all: Float = 0f
): Parcelable