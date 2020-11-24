package com.narify.forecasty.workers;

import android.content.Context;

import com.narify.forecasty.data.repository.WeatherRepo;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class ForecastWorker extends Worker {

    @Inject
    WeatherRepo weatherRepo;

    public ForecastWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        weatherRepo.refreshWeather();
        return Result.success();
    }
}
