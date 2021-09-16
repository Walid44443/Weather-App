package com.paymob.weather.ui.fragment.weatherList

import android.os.Bundle
import androidx.navigation.NavArgs
import com.paymob.weather.`data`.model.response.City
import java.lang.IllegalArgumentException
import kotlin.Array
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class WeatherContainerFragmentArgs(
  public val cities: Array<City>?
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putParcelableArray("cities", this.cities)
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("UNCHECKED_CAST")
    public fun fromBundle(bundle: Bundle): WeatherContainerFragmentArgs {
      bundle.setClassLoader(WeatherContainerFragmentArgs::class.java.classLoader)
      val __cities : Array<City>?
      if (bundle.containsKey("cities")) {
        __cities = bundle.getParcelableArray("cities")?.map { it as City }?.toTypedArray()
      } else {
        throw IllegalArgumentException("Required argument \"cities\" is missing and does not have an android:defaultValue")
      }
      return WeatherContainerFragmentArgs(__cities)
    }
  }
}
