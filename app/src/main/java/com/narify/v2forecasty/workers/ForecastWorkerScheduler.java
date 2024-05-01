package com.narify.v2forecasty.workers;

import java.util.concurrent.TimeUnit;

import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.narify.v2forecasty.singletons.AppContext;
import com.narify.v2forecasty.utils.DateUtils;

/**
 * A class for scheduling ForecastWorker in the WorkManager
 */
public class ForecastWorkerScheduler {

    public static final String FORECAST_WORK_TAG = "weather_forecast";
    public static final String FORECAST_UNIQUE_WORK_NAME = FORECAST_WORK_TAG;
    private static final int REPEAT_INTERVAL_HOURS = 24;

    /**
     * Schedule forecast work in the WorkManager
     */
    public static void init() {
        long initialDelay = DateUtils.getTimeLeftForDayEnd();
        PeriodicWorkRequest workRequest = setupWorkRequest(initialDelay);
        // Do not enqueue forecast sync with server work multiple times
        WorkManager.getInstance(AppContext.get()).enqueueUniquePeriodicWork(
                FORECAST_UNIQUE_WORK_NAME,
                ExistingPeriodicWorkPolicy.KEEP,
                workRequest);
    }

    /**
     * This function configures periodic work request that will be used to enqueue work
     *
     * @param initialDelayInMillis time delay to sync work timing with the start of every day
     * @return WorkRequest that is to be enqueued in WorkManager
     */
    private static PeriodicWorkRequest setupWorkRequest(long initialDelayInMillis) {
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();
        return new PeriodicWorkRequest.Builder(ForecastWorker.class,
                REPEAT_INTERVAL_HOURS, TimeUnit.HOURS)
                .setInitialDelay(initialDelayInMillis, TimeUnit.MILLISECONDS)
                .setConstraints(constraints)
                .addTag(FORECAST_WORK_TAG)
                .build();
    }
}
