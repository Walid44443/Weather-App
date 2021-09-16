package com.paymob.weather.ui.fragment.weatherList

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.paymob.weather.`data`.model.response.City
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class CityWeatherFragmentArgs(
  public val city: City?
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(City::class.java)) {
      result.putParcelable("city", this.city as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(City::class.java)) {
      result.putSerializable("city", this.city as Serializable?)
    } else {
      throw UnsupportedOperationException(City::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): CityWeatherFragmentArgs {
      bundle.setClassLoader(CityWeatherFragmentArgs::class.java.classLoader)
      val __city : City?
      if (bundle.containsKey("city")) {
        if (Parcelable::class.java.isAssignableFrom(City::class.java) ||
            Serializable::class.java.isAssignableFrom(City::class.java)) {
          __city = bundle.get("city") as City?
        } else {
          throw UnsupportedOperationException(City::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"city\" is missing and does not have an android:defaultValue")
      }
      return CityWeatherFragmentArgs(__city)
    }
  }
}
