package com.narify.v2forecasty.singletons;

import android.content.Context;

import com.narify.v2forecasty.ForecastyApplication;

public class AppContext {

    private static AppContext mInstance;

    private AppContext() {
    }

    private static synchronized AppContext getInstance() {
        if (mInstance == null) {
            mInstance = new AppContext();
        }
        return mInstance;
    }

    private static Context getContext() {
        return ForecastyApplication.getInstance();
    }

    public static synchronized Context get() {
        return getInstance().getContext();
    }
}
