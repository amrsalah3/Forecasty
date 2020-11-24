package com.narify.forecasty.di;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class ExecutorModule {

    @Singleton
    @Provides
    public static Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

}
