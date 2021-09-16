package com.paymob.weather.databinding;
import com.paymob.weather.R;
import com.paymob.weather.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemNextForecastingLayoutBindingImpl extends ItemNextForecastingLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.next_forecasting_header, 4);
        sViewsWithIds.put(R.id.next_forecasting_text, 5);
        sViewsWithIds.put(R.id.date_text, 6);
        sViewsWithIds.put(R.id.desc_img, 7);
    }
    // views
    @NonNull
    private final androidx.appcompat.widget.LinearLayoutCompat mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemNextForecastingLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private ItemNextForecastingLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[7]
            , (android.widget.TextView) bindings[2]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[4]
            , (android.widget.TextView) bindings[5]
            );
        this.dayText.setTag(null);
        this.degreeText.setTag(null);
        this.mboundView0 = (androidx.appcompat.widget.LinearLayoutCompat) bindings[0];
        this.mboundView0.setTag(null);
        this.nextDateText.setTag(null);
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
        java.lang.String dateUtilINSTANCEForecastingDateCardCityWeatherDtTxt = null;
        java.lang.String tempConverterUtilINSTANCEToRoundedCelsiusCityWeatherMainTemp = null;
        com.paymob.weather.data.model.response.Main cityWeatherMain = null;
        java.lang.String dateUtilINSTANCEDayOfWeekCityWeatherDtTxt = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (cityWeather != null) {
                    // read cityWeather.dtTxt
                    cityWeatherDtTxt = cityWeather.getDtTxt();
                    // read cityWeather.main
                    cityWeatherMain = cityWeather.getMain();
                }


                // read DateUtil.INSTANCE.forecastingDateCard(cityWeather.dtTxt)
                dateUtilINSTANCEForecastingDateCardCityWeatherDtTxt = com.paymob.weather.util.DateUtil.INSTANCE.forecastingDateCard(cityWeatherDtTxt);
                // read DateUtil.INSTANCE.dayOfWeek(cityWeather.dtTxt)
                dateUtilINSTANCEDayOfWeekCityWeatherDtTxt = com.paymob.weather.util.DateUtil.INSTANCE.dayOfWeek(cityWeatherDtTxt);
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

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.dayText, dateUtilINSTANCEDayOfWeekCityWeatherDtTxt);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.degreeText, tempConverterUtilINSTANCEToRoundedCelsiusCityWeatherMainTemp);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.nextDateText, dateUtilINSTANCEForecastingDateCardCityWeatherDtTxt);
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