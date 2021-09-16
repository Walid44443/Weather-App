package com.walid.weather.data.model.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class Sys (
    @SerializedName("pod")
    var pod: String? = null
): Parcelable