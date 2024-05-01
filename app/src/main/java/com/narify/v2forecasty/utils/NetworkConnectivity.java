package com.narify.v2forecasty.utils;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;

import timber.log.Timber;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;

import com.narify.v2forecasty.singletons.AppContext;
import com.narify.v2forecasty.singletons.AppExecutors;

@Singleton
public class NetworkConnectivity {
    private AppExecutors appExecutors;

    @Inject
    public NetworkConnectivity(AppExecutors appExecutors) {
        this.appExecutors = appExecutors;
    }

    public synchronized void checkInternetConnection(ConnectivityCallback callback) {
        appExecutors.getNetworkIO().execute(() -> {
            if (isNetworkAvailable()) {
                try {
                    HttpsURLConnection urlc = (HttpsURLConnection)
                            new URL("https://clients3.google.com/generate_204").openConnection();
                    urlc.setRequestProperty("User-Agent", "Android");
                    urlc.setRequestProperty("Connection", "close");
                    urlc.setConnectTimeout(1000);
                    urlc.connect();
                    boolean isConnected = urlc.getResponseCode() == 204 && urlc.getContentLength() == 0;
                    postCallback(callback, isConnected);
                } catch (IOException e) {
                    postCallback(callback, false);
                } catch (Exception e) {
                    Timber.d("GeneralLogKey: " + e);
                }
            } else {
                postCallback(callback, false);
            }
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager)
                AppContext.get().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) return false;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Network[] networks = cm.getAllNetworks();
            for (Network n : networks) {
                NetworkInfo nInfo = cm.getNetworkInfo(n);
                if (nInfo != null && nInfo.isConnected()) return true;
            }
        } else {
            NetworkInfo[] networks = cm.getAllNetworkInfo();
            for (NetworkInfo nInfo : networks) {
                if (nInfo != null && nInfo.isConnected()) return true;
            }
        }

        return false;
    }

    private void postCallback(ConnectivityCallback callBack, boolean isConnected) {
        appExecutors.mainThread().execute(() -> callBack.onFinished(isConnected));
    }

    public interface ConnectivityCallback {
        void onFinished(boolean isConnected);
    }

}
