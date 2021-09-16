package com.walid.weather.data.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City(
    @SerializedName("country")
    var country: String? = null,

    @SerializedName("coord")
    var coord: Coord? = null,

    @SerializedName("sunrise")
    var sunrise: Float = 0f,

    @SerializedName("timezone")
    var timezone: Float = 0f,

    @SerializedName("sunset")
    var sunset: Float = 0f,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("id")
    var id: Float = 0f,

    @SerializedName("population")
    var population: Float = 0f,
) : Parcelable {



}