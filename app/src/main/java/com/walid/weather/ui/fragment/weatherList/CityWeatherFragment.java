package com.walid.weather.ui.fragment.weatherList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.walid.weather.R;
import com.walid.weather.data.model.response.CityWeather;
import com.walid.weather.data.network.repo.WeatherForecastingRepo;
import com.walid.weather.databinding.CityWeatherFragmentBinding;
import com.walid.weather.ui.fragment.weatherList.adapter.WeatherForecastingAdapter;
import com.walid.weather.util.ItemClickListener;
import com.walid.weather.util.NavControllerGetter;
import com.walid.weather.util.UiHelper;
import com.walid.weather.util.domain.ViewState;

import java.util.HashMap;
import java.util.List;

public class CityWeatherFragment extends Fragment implements ItemClickListener<List<CityWeather>> {

    private CityWeatherViewModel mViewModel;
    private CityWeatherFragmentBinding binding;

    private WeatherForecastingRepo forecastingRepo;

    public static CityWeatherFragment newInstance() {
        return new CityWeatherFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CityWeatherFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CityWeatherViewModel.class);

        if (getArguments().getParcelable("city") != null)
            mViewModel.cityLiveData.postValue(getArguments().getParcelable("city"));
        // set layout manger as linear to display items as a vertical view
        LinearLayoutManager forecastingLinearLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );

        //attach layout manger to recyclerview
        binding.forecastingRecyclerview.setLayoutManager(forecastingLinearLayoutManager);

        //create adapter with empty data and pass this as OnClick listener to observe any click on item
        WeatherForecastingAdapter forecastingAdapter = new WeatherForecastingAdapter(new HashMap<>(), this);

        binding.forecastingRecyclerview.setAdapter(forecastingAdapter);


        mViewModel.cityLiveData.observe(getViewLifecycleOwner(), city -> {
            forecastingRepo = new WeatherForecastingRepo(city);
            forecastingRepo.fetchFromNetwork();

            forecastingRepo.getResultLive().observe(getViewLifecycleOwner(), resource -> {
                switch (resource.component1()) {
                    case ERROR:

                        if (resource.getMessage().contains("NETWORK_ERROR"))
                            mViewModel.viewStateMutableLiveData.postValue(ViewState.NetworkERROR);
                        else
                            mViewModel.viewStateMutableLiveData.postValue(ViewState.NoItems);
                        break;
                    case LOADING:
                        mViewModel.viewStateMutableLiveData.postValue(ViewState.Loading);
                        break;
                    case SUCCESS:
                        requireActivity().runOnUiThread(() -> {
                            mViewModel.viewStateMutableLiveData.postValue(
                                    //Change view state to no items or ready to display based on count of items
                                    (resource.getData().isEmpty()) ? ViewState.NoItems : ViewState.ReadyToDisplay);

                            forecastingAdapter.setDataSet(resource.getData());
                            forecastingAdapter.notifyDataSetChanged();
                        });
                        break;
                }
            });

        });

        mViewModel.viewStateMutableLiveData.observe(getViewLifecycleOwner(), state -> {
            binding.swipeRefreshWeather.setRefreshing(state == ViewState.Loading);

            switch (state) {
                case NetworkERROR:
                    binding.forecastingRecyclerview.setVisibility(View.GONE);
                    binding.noWeatherItems.setVisibility(View.GONE);
                    binding.noNetworkConnectionLayout.setVisibility(View.VISIBLE);
                    binding.swipeRefreshWeather.setEnabled(true);
                    break;
                case ReadyToDisplay:
                    binding.forecastingRecyclerview.setVisibility(View.VISIBLE);
                    binding.noWeatherItems.setVisibility(View.GONE);
                    binding.noNetworkConnectionLayout.setVisibility(View.GONE);
                    binding.swipeRefreshWeather.setEnabled(true);
                    break;
                case NoItems:
                    binding.forecastingRecyclerview.setVisibility(View.GONE);
                    binding.noWeatherItems.setVisibility(View.VISIBLE);
                    binding.noNetworkConnectionLayout.setVisibility(View.GONE);
                    binding.swipeRefreshWeather.setEnabled(false);
                    break;
            }
        });

        binding.swipeRefreshWeather.setOnRefreshListener(() -> {
            forecastingRepo.fetchFromNetwork();
        });
    }


    @Override
    public void onClick(@Nullable List<CityWeather> item, @Nullable View view) {
        Bundle bundle = new Bundle();
        CityWeather[] cityWeathers = new CityWeather[item.size()];
        item.toArray(cityWeathers); // fill the array

        bundle.putParcelableArray("cityWeatherList", cityWeathers);
        if (mViewModel.cityLiveData.getValue() != null) {
            bundle.putString("cityName", mViewModel.cityLiveData.getValue().getName());
            ((NavControllerGetter) requireActivity()).getHomeNavController().navigate(
                    R.id.dayForecastingDetailsDialogFragment,
                    bundle,
                    UiHelper.Companion.getNavOptions());
        }
    }
}