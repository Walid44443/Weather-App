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
data class Main(
    @SerializedName("temp")
    var temp: Float = 0.0f,

    @SerializedName("temp_min")
    var tempMin: Float = 0.0f,

    @SerializedName("grnd_level")
    var grndLevel: Float = 0.0f,

    @SerializedName("temp_kf")
    var tempKf: Float = 0.0f,

    @SerializedName("humidity")
    var humidity: Float = 0.0f,

    @SerializedName("pressure")
    var pressure: Float = 0.0f,

    @SerializedName("sea_level")
    var seaLevel: Float = 0.0f,

    @SerializedName("feels_like")
    var feelsLike: Float = 0.0f,

    @SerializedName("temp_max")
    var tempMax: Float = 0.0f,
) : Parcelable