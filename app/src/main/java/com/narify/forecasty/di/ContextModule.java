package com.narify.forecasty.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class ContextModule {

    @Singleton
    @Provides
    public static Context getAppContext(Application application) {
        return application;
    }

}
