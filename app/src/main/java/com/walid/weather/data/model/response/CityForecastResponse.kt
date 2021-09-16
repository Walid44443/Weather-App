package com.walid.weather.data.model.response

import com.google.gson.annotations.SerializedName

data class CityForecastResponse(
    @SerializedName("city")
    var city: City? = null,

    @SerializedName("cnt")
    var cnt: Float = 0f,

    @SerializedName("cod")
    var cod: String? = null,

    @SerializedName("message")
    var message: Int = 0,

    @SerializedName("list")
    var list: List<CityWeather>? = null
)