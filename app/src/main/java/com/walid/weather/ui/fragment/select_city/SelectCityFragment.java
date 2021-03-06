package com.walid.weather.ui.fragment.select_city;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.walid.weather.R;
import com.walid.weather.data.model.response.City;
import com.walid.weather.data.model.response.Coord;
import com.walid.weather.databinding.SelectCityFragmentBinding;
import com.walid.weather.ui.fragment.select_city.adapter.SelectedCitiesAdapter;
import com.walid.weather.util.NavControllerGetter;
import com.walid.weather.util.PermissionUtil;
import com.walid.weather.util.UiHelper;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
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


        //set click listener for each elements ( this.OnClick(View view) Listener )
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

        //observe when any new entered data would insert into adapter of cities chips
        mViewModel.listLiveData.observe(getViewLifecycleOwner(), cities -> {
            getActivity().runOnUiThread(() -> {
                selectedCitiesAdapter.setDataSet(cities);
                selectedCitiesAdapter.notifyDataSetChanged();
            });
        });

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirm_btn:

                //check the condition `User should enter minimum 3 cities and max 7 cities.`
                if (mViewModel.listLiveData.getValue().size() >= 3 && mViewModel.listLiveData.getValue().size() <= 7) {
                    Bundle bundle = new Bundle();
                    //create new array with length of list to copy data to it
                    City[] citiesArray = new City[mViewModel.listLiveData.getValue().size()];
                    //copying data process to array because array is easier to pass data as parcelable
                    for (int i = 0; i < citiesArray.length; i++)
                        citiesArray[i] = mViewModel.listLiveData.getValue().get(i);

                    bundle.putParcelableArray("cities", citiesArray);
                    ((NavControllerGetter) requireActivity())
                            .getHomeNavController()
                            .navigate(R.id.weatherContainerFragment,
                                    bundle,
                                    UiHelper.Companion.getNavOptions()
                            );
                } else
                    Toast.makeText(getContext(), R.string.enter_city_restriction_error, Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_city_btn:
                addCities(binding.citiesEdt.getText().toString());
                //delete data from edit text as ux principal after passing data
                binding.citiesEdt.setText("");
                break;
            case R.id.current_location:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    getAndAddCurrentCity();
                }
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void getAndAddCurrentCity() {
        PermissionUtil.checkPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION,
                new PermissionUtil.PermissionAskListener() {
                    @Override
                    public void onPermissionAsk() {
                        ActivityCompat.requestPermissions(
                                getActivity(),
                                new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 3000
                        );
                    }

                    @Override
                    public void onPermissionPreviouslyDenied() {
                        Toast.makeText(getContext(), getContext().getString(R.string.permission_disabled), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionDisabled() {
                        Toast.makeText(getContext(), getContext().getString(R.string.permission_disabled), Toast.LENGTH_SHORT).show();
                    }

                    @SuppressLint("MissingPermission")
                    @Override
                    public void onPermissionGranted() {
                        fusedLocationClient.getLastLocation()
                                .addOnSuccessListener(getActivity(), location -> {

                                    if (location != null) {
                                        for (City city : Objects.requireNonNull(mViewModel.listLiveData.getValue())) {
                                            if (city.getCoord() != null)
                                                return;
                                        }
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
                    }
                });

    }

    private void addCities(String cities) {
        String[] citesArr = cities.trim().split(",");
        List<City> newCitiesList = mViewModel.listLiveData.getValue();
        for (String cityString : citesArr) {
            if (!cityString.trim().isEmpty()) {
                City city = new City();
                city.setName(cityString.trim());
                if (newCitiesList.size() < 7)
                    newCitiesList.add(city);
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mViewModel.listLiveData.postValue(newCitiesList.stream().distinct().collect(Collectors.toList()));
        }
    }
}