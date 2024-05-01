package com.narify.v2forecasty.workers;

import javax.inject.Inject;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.narify.v2forecasty.data.repository.WeatherRepo;

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
