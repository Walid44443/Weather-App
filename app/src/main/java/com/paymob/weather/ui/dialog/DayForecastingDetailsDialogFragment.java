package com.paymob.weather.ui.dialog;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paymob.weather.R;

import org.jetbrains.annotations.NotNull;

public class DayForecastingDetailsDialogFragment extends Fragment {

    private DayForecastingDetailsViewModel mViewModel;

    public static DayForecastingDetailsDialogFragment newInstance() {
        return new DayForecastingDetailsDialogFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        //binding = CityWeatherFragmentBinding.inflate(inflater, container, false);
        //return binding.getRoot();

        return inflater.inflate(R.layout.day_forecasting_details_dialog_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}