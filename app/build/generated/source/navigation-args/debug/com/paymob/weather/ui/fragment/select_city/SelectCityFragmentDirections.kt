package com.paymob.weather.ui.fragment.select_city

import android.os.Bundle
import androidx.navigation.NavDirections
import com.paymob.weather.R
import com.paymob.weather.`data`.model.response.City
import kotlin.Array
import kotlin.Int

public class SelectCityFragmentDirections private constructor() {
  private data class ActionSelectCityFragmentToWeatherContainerFragment(
    public val cities: Array<City>?
  ) : NavDirections {
    public override fun getActionId(): Int =
        R.id.action_selectCityFragment_to_weatherContainerFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putParcelableArray("cities", this.cities)
      return result
    }
  }

  public companion object {
    public fun actionSelectCityFragmentToWeatherContainerFragment(cities: Array<City>?):
        NavDirections = ActionSelectCityFragmentToWeatherContainerFragment(cities)
  }
}
