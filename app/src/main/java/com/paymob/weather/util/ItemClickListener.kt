package com.paymob.weather.util

import android.view.View

interface ItemClickListener<T> {
    fun onClick(item: T?, view: View?)
}