package com.walid.weather.util

import android.view.View
import android.view.animation.*
import androidx.navigation.NavOptions
import com.walid.weather.R


object AnimUtil {
    fun setFadeInAnimation(view: View?, FADE_DURATION: Int) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.interpolator = AccelerateInterpolator() //and this
        anim.duration = FADE_DURATION.toLong()
        view?.startAnimation(anim)
        view?.visibility = View.VISIBLE
    }

    fun setFadeOutAnimation(view: View?, FADE_DURATION: Int) {
        val anim = AlphaAnimation(1.0f, 0.0f)
        anim.duration = FADE_DURATION.toLong()
        view?.startAnimation(anim)
        view?.visibility = View.INVISIBLE
    }

    fun getNavOptions(): NavOptions? {
        return NavOptions.Builder()
            .setEnterAnim(R.anim.slide_up2)
            .setExitAnim(R.anim.slide_bottom2)
            .build()
    }
}


