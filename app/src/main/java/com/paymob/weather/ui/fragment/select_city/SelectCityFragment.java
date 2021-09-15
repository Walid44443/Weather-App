package com.paymob.weather.ui.fragment.select_city;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.paymob.weather.R;
import com.paymob.weather.data.model.response.City;
import com.paymob.weather.data.model.response.Coord;
import com.paymob.weather.databinding.SelectCityFragmentBinding;
import com.paymob.weather.ui.fragment.select_city.adapter.SelectedCitiesAdapter;
import com.paymob.weather.util.NavControllerGetter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

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
        binding.addCityBtn.setOnClickListener(this);
        binding.confirmBtn.setOnClickListener(this);
        binding.currentLocation.setOnClickListener(this);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity());


        // set layout manger as linear to display items as a vertical view
        LinearLayoutManager forecastingLinearLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );

        //attach layout manger to recyclerview
        binding.citiesRecyclerview.setLayoutManager(forecastingLinearLayoutManager);
        SelectedCitiesAdapter selectedCitiesAdapter = new SelectedCitiesAdapter();
        binding.citiesRecyclerview.setAdapter(selectedCitiesAdapter);

        mViewModel.listLiveData.observe(getViewLifecycleOwner(), cities -> {
            getActivity().runOnUiThread(() -> {
                selectedCitiesAdapter.setDataSet(cities);
                selectedCitiesAdapter.notifyDataSetChanged();
            });
        });

    }

    private ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    getAndAddCurrentCity();
                } else {
                    // Explain to the user that the feature is unavailable because the
                    // features requires a permission that the user has denied. At the
                    // same time, respect the user's decision. Don't link to system
                    // settings in an effort to convince the user to change their
                    // decision.
                }
            });

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirm_btn:
                if (mViewModel.listLiveData.getValue().size() >= 3 && mViewModel.listLiveData.getValue().size() <= 7) {
                    Bundle bundle = new Bundle();
                    City[] citiesArray = new City[mViewModel.listLiveData.getValue().size()];

                    for (int i = 0; i < citiesArray.length; i++)
                        citiesArray[i] = mViewModel.listLiveData.getValue().get(i);

                    bundle.putParcelableArray("cities", citiesArray);
                    ((NavControllerGetter) requireActivity())
                            .getHomeNavController()
                            .navigate(R.id.cityWeatherFragment,
                                    bundle
                            );
                } else
                    Toast.makeText(getContext(), R.string.enter_city_restriction_error, Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_city_btn:
                addCities(binding.citiesEdt.getText().toString());
                binding.citiesEdt.setText("");
                break;
            case R.id.current_location:
                getAndAddCurrentCity();
                break;
        }
    }

    private void getAndAddCurrentCity() {
        if (ActivityCompat.checkSelfPermission(requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(getActivity(), location -> {
                        if (location != null) {
                            City city = new City();
                            Coord coord = new Coord();
                            coord.setLat(location.getLatitude());
                            coord.setLon(location.getLongitude());
                            city.setCoord(coord);
                            List<City> newCitiesList = mViewModel.listLiveData.getValue();
                            newCitiesList.add(city);
                            mViewModel.listLiveData.postValue(newCitiesList);
                        }
                    });
        } else {
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_COARSE_LOCATION);
        }
    }

    private void addCities(String cities) {
        String[] citesArr = cities.trim().split(",");
        List<City> newCitiesList = mViewModel.listLiveData.getValue();
        for (String cityString : citesArr) {
            City city = new City();
            city.setName(cityString);
            if (newCitiesList.size() < 7)
                newCitiesList.add(city);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mViewModel.listLiveData.postValue(newCitiesList.stream().distinct().collect(Collectors.toList()));
        }
    }
}