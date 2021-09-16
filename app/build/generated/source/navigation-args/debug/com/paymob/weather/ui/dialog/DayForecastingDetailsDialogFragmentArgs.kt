package com.paymob.weather.ui.dialog

import android.os.Bundle
import androidx.navigation.NavArgs
import com.paymob.weather.`data`.model.response.CityWeather
import java.lang.IllegalArgumentException
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class DayForecastingDetailsDialogFragmentArgs(
  public val cityWeatherList: Array<CityWeather>?,
  public val cityName: String?
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putParcelableArray("cityWeatherList", this.cityWeatherList)
    result.putString("cityName", this.cityName)
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("UNCHECKED_CAST")
    public fun fromBundle(bundle: Bundle): DayForecastingDetailsDialogFragmentArgs {
      bundle.setClassLoader(DayForecastingDetailsDialogFragmentArgs::class.java.classLoader)
      val __cityWeatherList : Array<CityWeather>?
      if (bundle.containsKey("cityWeatherList")) {
        __cityWeatherList = bundle.getParcelableArray("cityWeatherList")?.map { it as CityWeather
            }?.toTypedArray()
      } else {
        throw IllegalArgumentException("Required argument \"cityWeatherList\" is missing and does not have an android:defaultValue")
      }
      val __cityName : String?
      if (bundle.containsKey("cityName")) {
        __cityName = bundle.getString("cityName")
      } else {
        throw IllegalArgumentException("Required argument \"cityName\" is missing and does not have an android:defaultValue")
      }
      return DayForecastingDetailsDialogFragmentArgs(__cityWeatherList, __cityName)
    }
  }
}
