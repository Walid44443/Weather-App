package com.walid.weather.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtil {
    public static void firstTimeAskingPermission(Context context, String permission, boolean isFirstTime) {
        SharedPreferences sharedPreference = context.getSharedPreferences(CONST.PREFS_FILE_NAME, Context.MODE_PRIVATE);
        sharedPreference.edit().putBoolean(permission, isFirstTime).apply();
    }

    public static boolean isFirstTimeAskingPermission(Context context, String permission) {
        return context.getSharedPreferences(CONST.PREFS_FILE_NAME, Context.MODE_PRIVATE).getBoolean(permission, true);
    }
}
