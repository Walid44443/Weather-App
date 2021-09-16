package com.paymob.weather;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.paymob.weather.databinding.CityWeatherFragmentBindingImpl;
import com.paymob.weather.databinding.DayForecastingDetailsDialogFragmentBindingImpl;
import com.paymob.weather.databinding.ItemHourForecastingForTodayLayoutBindingImpl;
import com.paymob.weather.databinding.ItemNextForecastingLayoutBindingImpl;
import com.paymob.weather.databinding.ItemSelectedCityLayoutBindingImpl;
import com.paymob.weather.databinding.ItemTodayForecastingLayoutBindingImpl;
import com.paymob.weather.databinding.SelectCityFragmentBindingImpl;
import com.paymob.weather.databinding.WeatherContainerFragmentBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_CITYWEATHERFRAGMENT = 1;

  private static final int LAYOUT_DAYFORECASTINGDETAILSDIALOGFRAGMENT = 2;

  private static final int LAYOUT_ITEMHOURFORECASTINGFORTODAYLAYOUT = 3;

  private static final int LAYOUT_ITEMNEXTFORECASTINGLAYOUT = 4;

  private static final int LAYOUT_ITEMSELECTEDCITYLAYOUT = 5;

  private static final int LAYOUT_ITEMTODAYFORECASTINGLAYOUT = 6;

  private static final int LAYOUT_SELECTCITYFRAGMENT = 7;

  private static final int LAYOUT_WEATHERCONTAINERFRAGMENT = 8;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(8);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.paymob.weather.R.layout.city_weather_fragment, LAYOUT_CITYWEATHERFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.paymob.weather.R.layout.day_forecasting_details_dialog_fragment, LAYOUT_DAYFORECASTINGDETAILSDIALOGFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.paymob.weather.R.layout.item_hour_forecasting_for_today_layout, LAYOUT_ITEMHOURFORECASTINGFORTODAYLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.paymob.weather.R.layout.item_next_forecasting_layout, LAYOUT_ITEMNEXTFORECASTINGLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.paymob.weather.R.layout.item_selected_city_layout, LAYOUT_ITEMSELECTEDCITYLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.paymob.weather.R.layout.item_today_forecasting_layout, LAYOUT_ITEMTODAYFORECASTINGLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.paymob.weather.R.layout.select_city_fragment, LAYOUT_SELECTCITYFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.paymob.weather.R.layout.weather_container_fragment, LAYOUT_WEATHERCONTAINERFRAGMENT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_CITYWEATHERFRAGMENT: {
          if ("layout/city_weather_fragment_0".equals(tag)) {
            return new CityWeatherFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for city_weather_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_DAYFORECASTINGDETAILSDIALOGFRAGMENT: {
          if ("layout/day_forecasting_details_dialog_fragment_0".equals(tag)) {
            return new DayForecastingDetailsDialogFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for day_forecasting_details_dialog_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMHOURFORECASTINGFORTODAYLAYOUT: {
          if ("layout/item_hour_forecasting_for_today_layout_0".equals(tag)) {
            return new ItemHourForecastingForTodayLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_hour_forecasting_for_today_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMNEXTFORECASTINGLAYOUT: {
          if ("layout/item_next_forecasting_layout_0".equals(tag)) {
            return new ItemNextForecastingLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_next_forecasting_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMSELECTEDCITYLAYOUT: {
          if ("layout/item_selected_city_layout_0".equals(tag)) {
            return new ItemSelectedCityLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_selected_city_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMTODAYFORECASTINGLAYOUT: {
          if ("layout/item_today_forecasting_layout_0".equals(tag)) {
            return new ItemTodayForecastingLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_today_forecasting_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_SELECTCITYFRAGMENT: {
          if ("layout/select_city_fragment_0".equals(tag)) {
            return new SelectCityFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for select_city_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_WEATHERCONTAINERFRAGMENT: {
          if ("layout/weather_container_fragment_0".equals(tag)) {
            return new WeatherContainerFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for weather_container_fragment is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "city");
      sKeys.put(2, "cityName");
      sKeys.put(3, "cityWeather");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(8);

    static {
      sKeys.put("layout/city_weather_fragment_0", com.paymob.weather.R.layout.city_weather_fragment);
      sKeys.put("layout/day_forecasting_details_dialog_fragment_0", com.paymob.weather.R.layout.day_forecasting_details_dialog_fragment);
      sKeys.put("layout/item_hour_forecasting_for_today_layout_0", com.paymob.weather.R.layout.item_hour_forecasting_for_today_layout);
      sKeys.put("layout/item_next_forecasting_layout_0", com.paymob.weather.R.layout.item_next_forecasting_layout);
      sKeys.put("layout/item_selected_city_layout_0", com.paymob.weather.R.layout.item_selected_city_layout);
      sKeys.put("layout/item_today_forecasting_layout_0", com.paymob.weather.R.layout.item_today_forecasting_layout);
      sKeys.put("layout/select_city_fragment_0", com.paymob.weather.R.layout.select_city_fragment);
      sKeys.put("layout/weather_container_fragment_0", com.paymob.weather.R.layout.weather_container_fragment);
    }
  }
}
