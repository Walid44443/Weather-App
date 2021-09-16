package com.paymob.weather.databinding;
import com.paymob.weather.R;
import com.paymob.weather.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemSelectedCityLayoutBindingImpl extends ItemSelectedCityLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemSelectedCityLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 1, sIncludes, sViewsWithIds));
    }
    private ItemSelectedCityLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.chip.Chip) bindings[0]
            );
        this.cityName.setTag(null);
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
        if (BR.city == variableId) {
            setCity((com.paymob.weather.data.model.response.City) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCity(@Nullable com.paymob.weather.data.model.response.City City) {
        this.mCity = City;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.city);
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
        java.lang.String cityNameJavaLangObjectNullCityNameAndroidStringCurrentCityCityName = null;
        com.paymob.weather.data.model.response.City city = mCity;
        java.lang.String CityName1 = null;
        int cityNameJavaLangObjectNullCityNameAndroidColorMainScreenCardColorSelectedCityNameAndroidColorCardBgColor = 0;
        boolean cityNameJavaLangObjectNull = false;

        if ((dirtyFlags & 0x3L) != 0) {



                if (city != null) {
                    // read city.name
                    CityName1 = city.getName();
                }


                // read city.name == null
                cityNameJavaLangObjectNull = (CityName1) == (null);
            if((dirtyFlags & 0x3L) != 0) {
                if(cityNameJavaLangObjectNull) {
                        dirtyFlags |= 0x8L;
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x4L;
                        dirtyFlags |= 0x10L;
                }
            }


                // read city.name == null ? @android:color/main_screen_card_color_selected : @android:color/card_bg_color
                cityNameJavaLangObjectNullCityNameAndroidColorMainScreenCardColorSelectedCityNameAndroidColorCardBgColor = ((cityNameJavaLangObjectNull) ? (getColorFromResource(cityName, R.color.main_screen_card_color_selected)) : (getColorFromResource(cityName, R.color.card_bg_color)));
        }
        // batch finished

        if ((dirtyFlags & 0x3L) != 0) {

                // read city.name == null ? @android:string/current_city : city.name
                cityNameJavaLangObjectNullCityNameAndroidStringCurrentCityCityName = ((cityNameJavaLangObjectNull) ? (cityName.getResources().getString(R.string.current_city)) : (CityName1));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.cityName.setChipBackgroundColor(androidx.databinding.adapters.Converters.convertColorToColorStateList(cityNameJavaLangObjectNullCityNameAndroidColorMainScreenCardColorSelectedCityNameAndroidColorCardBgColor));
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cityName, cityNameJavaLangObjectNullCityNameAndroidStringCurrentCityCityName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): city
        flag 1 (0x2L): null
        flag 2 (0x3L): city.name == null ? @android:string/current_city : city.name
        flag 3 (0x4L): city.name == null ? @android:string/current_city : city.name
        flag 4 (0x5L): city.name == null ? @android:color/main_screen_card_color_selected : @android:color/card_bg_color
        flag 5 (0x6L): city.name == null ? @android:color/main_screen_card_color_selected : @android:color/card_bg_color
    flag mapping end*/
    //end
}