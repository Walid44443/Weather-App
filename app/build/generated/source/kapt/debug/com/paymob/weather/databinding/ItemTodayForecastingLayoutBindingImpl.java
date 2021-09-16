package com.paymob.weather.databinding;
import com.paymob.weather.R;
import com.paymob.weather.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemTodayForecastingLayoutBindingImpl extends ItemTodayForecastingLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.today_forecasting_header, 2);
        sViewsWithIds.put(R.id.today_text, 3);
        sViewsWithIds.put(R.id.hourly_recyclerview, 4);
    }
    // views
    @NonNull
    private final androidx.appcompat.widget.LinearLayoutCompat mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemTodayForecastingLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemTodayForecastingLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[4]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.dateText.setTag(null);
        this.mboundView0 = (androidx.appcompat.widget.LinearLayoutCompat) bindings[0];
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
        java.lang.String cityWeatherDtTxt = null;
        java.lang.String dateUtilINSTANCEDateInDetailsDialogCityWeatherDtTxt = null;
        com.paymob.weather.data.model.response.CityWeather cityWeather = mCityWeather;

        if ((dirtyFlags & 0x3L) != 0) {



                if (cityWeather != null) {
                    // read cityWeather.dtTxt
                    cityWeatherDtTxt = cityWeather.getDtTxt();
                }


                // read DateUtil.INSTANCE.dateInDetailsDialog(cityWeather.dtTxt)
                dateUtilINSTANCEDateInDetailsDialogCityWeatherDtTxt = com.paymob.weather.util.DateUtil.INSTANCE.dateInDetailsDialog(cityWeatherDtTxt);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.dateText, dateUtilINSTANCEDateInDetailsDialogCityWeatherDtTxt);
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