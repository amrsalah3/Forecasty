package com.narify.v2forecasty;

import dagger.hilt.android.HiltAndroidApp;
import timber.log.Timber;

import androidx.multidex.MultiDexApplication;

@HiltAndroidApp
public class ForecastyApplication extends MultiDexApplication {
    private static ForecastyApplication mInstance;

    public static ForecastyApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
    }

}
