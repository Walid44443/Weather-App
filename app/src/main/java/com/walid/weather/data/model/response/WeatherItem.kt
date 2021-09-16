package com.walid.weather.data.model.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

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