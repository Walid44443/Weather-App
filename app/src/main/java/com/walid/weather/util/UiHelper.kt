package com.walid.weather.util

import android.app.Activity
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import androidx.navigation.NavOptions
import com.walid.weather.R


class UiHelper {
    companion object {

        fun switchVisibilityView(v1: View, v2: View, activity: Activity) {
            activity.let {
                if (v2.visibility == View.GONE || v2.visibility == View.INVISIBLE)
                    AnimUtil.setFadeInAnimation(v2, 500)
                if (v1.visibility == View.VISIBLE)
                    AnimUtil.setFadeOutAnimation(v1, 500)

                v1.visibility = View.GONE
                v2.visibility = View.VISIBLE
            }
        }

        fun freezeButton(btn: Button?) {

            object : CountDownTimer(3000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    if (btn?.context != null)
                        btn.isClickable = false
                    btn?.isEnabled = false
                }

                override fun onFinish() {
                    if (btn?.context != null)
                        deFreezeButton(btn)
                }
            }.start()
        }

        fun deFreezeButton(btn: Button?) {
            if (btn?.context != null)
                btn.isClickable = true
            btn?.isEnabled = true

        }

        fun getNavOptions(): NavOptions? {
            return NavOptions.Builder()
                .setEnterAnim(R.anim.slide_up2)
                .setExitAnim(R.anim.slide_bottom2)
                .build()
        }

    }
}
