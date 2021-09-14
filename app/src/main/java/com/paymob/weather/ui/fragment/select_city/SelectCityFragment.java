package com.paymob.weather.ui.fragment.select_city;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.paymob.weather.R;
import com.paymob.weather.databinding.CityWeatherFragmentBinding;
import com.paymob.weather.databinding.SelectCityFragmentBinding;
import com.paymob.weather.util.NavControllerGetter;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executor;

public class SelectCityFragment extends Fragment implements View.OnClickListener {


    public static SelectCityFragment newInstance() {
        return new SelectCityFragment();
    }

    private SelectCityViewModel mViewModel;
    private SelectCityFragmentBinding binding;
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = SelectCityFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SelectCityViewModel.class);
        binding.btnLogin.setOnClickListener(this);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity());

        /*if (ActivityCompat.checkSelfPermission(requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return registerForActivityResult(ActivityResultContract, ActivityResultCallback) ();
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener((Executor) this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {

                        }
                    }
                });

         */
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                ((NavControllerGetter) requireActivity())
                        .getHomeNavController()
                        .navigate(R.id.cityWeatherFragment);
                break;
        }
    }
}