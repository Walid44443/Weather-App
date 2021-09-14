package com.paymob.weather.data.network.repo

import android.telecom.Call
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.paymob.weather.data.network.core.RetrofitClient
import com.paymob.weather.util.domain.Resource

internal abstract class Repository<ResultType> @MainThread internal constructor() {
    protected val result = MutableLiveData<Resource<ResultType>>(Resource.loading(null))
    protected val apiInterface: RetrofitClient = RetrofitClient.getInstance();

    init {/*
        if (shouldFetch(result.value?.data)) {
            fetchFromNetwork()
        }
        */
    }


    protected abstract fun fetchFromNetwork()

    @MainThread
    protected abstract fun shouldFetch(data: ResultType?): Boolean

}