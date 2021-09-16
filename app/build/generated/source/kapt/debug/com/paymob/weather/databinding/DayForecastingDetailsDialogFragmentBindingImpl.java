package com.paymob.weather.databinding;
import com.paymob.weather.R;
import com.paymob.weather.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DayForecastingDetailsDialogFragmentBindingImpl extends DayForecastingDetailsDialogFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cardView, 6);
        sViewsWithIds.put(R.id.desc_img, 7);
        sViewsWithIds.put(R.id.weather_describe, 8);
        sViewsWithIds.put(R.id.box_details, 9);
        sViewsWithIds.put(R.id.hourly_recyclerview, 10);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DayForecastingDetailsDialogFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private DayForecastingDetailsDialogFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[9]
            , (androidx.cardview.widget.CardView) bindings[6]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[7]
            , (androidx.recyclerview.widget.RecyclerView) bindings[10]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            , (android.widget.TextView) bindings[8]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[5]
            );
        this.cityName.setTag(null);
        this.currentDate.setTag(null);
        this.maxTempValue.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.minTempValue.setTag(null);
        this.windSpeedValue.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.cityWeather == variableId) {
            setCityWeather((com.paymob.weather.data.model.response.CityWeather) variable);
        }
        else if (BR.cityName == variableId) {
            setCityName((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCityWeather(@Nullable com.paymob.weather.data.model.response.CityWeather CityWeather) {
        this.mCityWeather = CityWeather;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.cityWeather);
        super.requestRebind();
    }
    public void setCityName(@Nullable java.lang.String CityName) {
        this.mCityName = CityName;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.cityName);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String dateUtilINSTANCEDateInDetailsDialogCityWeatherDtTxt = null;
        java.lang.String tempConverterUtilINSTANCEToRoundedCelsiusCityWeatherMainTempMax = null;
        com.paymob.weather.data.model.response.Main cityWeatherMain = null;
        java.lang.String cityWeatherDtTxt = null;
        java.lang.String tempConverterUtilINSTANCEToRoundedCelsiusCityWeatherMainTempMin = null;
        com.paymob.weather.data.model.response.CityWeather cityWeather = mCityWeather;
        float cityWeatherMainTempMin = 0f;
        float cityWeatherWindSpeed = 0f;
        java.lang.String CityName1 = mCityName;
        java.lang.String tempConverterUtilINSTANCEToRoundedCelsiusCityWeatherWindSpeed = null;
        float cityWeatherMainTempMax = 0f;
        com.paymob.weather.data.model.response.Wind cityWeatherWind = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (cityWeather != null) {
                    // read cityWeather.main
                    cityWeatherMain = cityWeather.getMain();
                    // read cityWeather.dtTxt
                    cityWeatherDtTxt = cityWeather.getDtTxt();
                    // read cityWeather.wind
                    cityWeatherWind = cityWeather.getWind();
                }


                if (cityWeatherMain != null) {
                    // read cityWeather.main.tempMin
                    cityWeatherMainTempMin = cityWeatherMain.getTempMin();
                    // read cityWeather.main.tempMax
                    cityWeatherMainTempMax = cityWeatherMain.getTempMax();
                }
                // read DateUtil.INSTANCE.dateInDetailsDialog(cityWeather.dtTxt)
                dateUtilINSTANCEDateInDetailsDialogCityWeatherDtTxt = com.paymob.weather.util.DateUtil.INSTANCE.dateInDetailsDialog(cityWeatherDtTxt);
                if (cityWeatherWind != null) {
                    // read cityWeather.wind.speed
                    cityWeatherWindSpeed = cityWeatherWind.getSpeed();
                }


                // read TempConverterUtil.INSTANCE.toRoundedCelsius(cityWeather.main.tempMin)
                tempConverterUtilINSTANCEToRoundedCelsiusCityWeatherMainTempMin = com.paymob.weather.util.TempConverterUtil.INSTANCE.toRoundedCelsius(cityWeatherMainTempMin);
                // read TempConverterUtil.INSTANCE.toRoundedCelsius(cityWeather.main.tempMax)
                tempConverterUtilINSTANCEToRoundedCelsiusCityWeatherMainTempMax = com.paymob.weather.util.TempConverterUtil.INSTANCE.toRoundedCelsius(cityWeatherMainTempMax);
                // read TempConverterUtil.INSTANCE.toRoundedCelsius(cityWeather.wind.speed)
                tempConverterUtilINSTANCEToRoundedCelsiusCityWeatherWindSpeed = com.paymob.weather.util.TempConverterUtil.INSTANCE.toRoundedCelsius(cityWeatherWindSpeed);
        }
        if ((dirtyFlags & 0x6L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cityName, CityName1);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.currentDate, dateUtilINSTANCEDateInDetailsDialogCityWeatherDtTxt);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.maxTempValue, tempConverterUtilINSTANCEToRoundedCelsiusCityWeatherMainTempMax);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.minTempValue, tempConverterUtilINSTANCEToRoundedCelsiusCityWeatherMainTempMin);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.windSpeedValue, tempConverterUtilINSTANCEToRoundedCelsiusCityWeatherWindSpeed);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): cityWeather
        flag 1 (0x2L): cityName
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}