package com.narify.forecasty;

import androidx.multidex.MultiDexApplication;
import dagger.hilt.android.HiltAndroidApp;
import timber.log.Timber;

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