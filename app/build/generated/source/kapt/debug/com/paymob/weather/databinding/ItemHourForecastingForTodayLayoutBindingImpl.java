package com.paymob.weather.databinding;
import com.paymob.weather.R;
import com.paymob.weather.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemHourForecastingForTodayLayoutBindingImpl extends ItemHourForecastingForTodayLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemHourForecastingForTodayLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private ItemHourForecastingForTodayLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.degreeText.setTag(null);
        this.hourText.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        float cityWeatherMainTemp = 0f;
        java.lang.String cityWeatherDtTxt = null;
        com.paymob.weather.data.model.response.CityWeather cityWeather = mCityWeather;
        java.lang.String tempConverterUtilINSTANCEToRoundedCelsiusCityWeatherMainTemp = null;
        com.paymob.weather.data.model.response.Main cityWeatherMain = null;
        java.lang.String dateUtilINSTANCETodayForecastingHourCardCityWeatherDtTxt = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (cityWeather != null) {
                    // read cityWeather.dtTxt
                    cityWeatherDtTxt = cityWeather.getDtTxt();
                    // read cityWeather.main
                    cityWeatherMain = cityWeather.getMain();
                }


                // read DateUtil.INSTANCE.todayForecastingHourCard(cityWeather.dtTxt)
                dateUtilINSTANCETodayForecastingHourCardCityWeatherDtTxt = com.paymob.weather.util.DateUtil.INSTANCE.todayForecastingHourCard(cityWeatherDtTxt);
                if (cityWeatherMain != null) {
                    // read cityWeather.main.temp
                    cityWeatherMainTemp = cityWeatherMain.getTemp();
                }


                // read TempConverterUtil.INSTANCE.toRoundedCelsius(cityWeather.main.temp)
                tempConverterUtilINSTANCEToRoundedCelsiusCityWeatherMainTemp = com.paymob.weather.util.TempConverterUtil.INSTANCE.toRoundedCelsius(cityWeatherMainTemp);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.degreeText, tempConverterUtilINSTANCEToRoundedCelsiusCityWeatherMainTemp);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.hourText, dateUtilINSTANCETodayForecastingHourCardCityWeatherDtTxt);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): cityWeather
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}