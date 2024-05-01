package com.narify.v2forecasty.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import android.app.Application;
import android.content.Context;

@Module
@InstallIn(ApplicationComponent.class)
public class ContextModule {

    @Singleton
    @Provides
    public static Context getAppContext(Application application) {
        return application;
    }

}
