package com.narify.forecasty.singletons;

import android.content.res.Resources;

import com.narify.forecasty.ForecastyApplication;

public class AppResources {

    private static AppResources mInstance;

    private AppResources() {
    }

    private static synchronized AppResources getInstance() {
        if (mInstance == null) {
            mInstance = new AppResources();
        }
        return mInstance;
    }

    private static Resources getResources() {
        return ForecastyApplication.getInstance().getResources();
    }

    public static synchronized Resources get() {
        return getInstance().getResources();
    }
}
