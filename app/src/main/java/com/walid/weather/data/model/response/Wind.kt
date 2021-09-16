package com.walid.weather.data.model.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class Wind(
    @SerializedName("deg")
    var deg: Float = 0f,

    @SerializedName("speed")
    var speed: Float = 0f,

    @SerializedName("gust")
    var gust: Float = 0.0f,
) : Parcelable