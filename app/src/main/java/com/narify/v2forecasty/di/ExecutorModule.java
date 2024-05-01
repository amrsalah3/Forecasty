package com.narify.v2forecasty.di;

import javax.inject.Singleton;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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
