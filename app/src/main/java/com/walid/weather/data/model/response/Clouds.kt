package com.walid.weather.data.model.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class Clouds(
    @SerializedName("all")
    var all: Float = 0f
): Parcelable