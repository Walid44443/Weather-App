package com.walid.weather.data.model.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
class Coord(
    @SerializedName("lon")
    var lon: Double = 0.0,

    @SerializedName("lat")
    var lat: Double = 0.0,
) : Parcelable