package com.walid.weather.data.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CityWeather(
    @SerializedName("dt")
    var dt: Long = 0,

    @SerializedName("pop")
    var pop: Double = 0.0,

    @SerializedName("visibility")
    var visibility: Int = 0,

    @SerializedName("dt_txt")
    var dtTxt: String = "",

    @SerializedName("weather")
    var weather: List<WeatherItem>? = null,

    @SerializedName("main")
    var main: Main? = null,

    @SerializedName("clouds")
    var clouds: Clouds? = null,

    @SerializedName("sys")
    var sys: Sys? = null,

    @SerializedName("wind")
    var wind: Wind,
) : Parcelable