package com.technawabs.bankbuddy.activities;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    protected String getTAG() {
        return TAG;
    }
}
