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
data class WeatherItem(
    @SerializedName("icon")
    var icon: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("main")
    var main: String? = null,

    @SerializedName("id")
    var id: Int = 0,
): Parcelable