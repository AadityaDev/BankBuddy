package com.technawabs.bankbuddy.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import com.technawabs.bankbuddy.network.exceptions.HttpException;

import org.json.JSONException;

import java.security.NoSuchAlgorithmException;

public class ExceptionUtility {

    public static void exceptionMessage(@NonNull Exception exception, @NonNull String TAG) {
        if (StringUtils.isNull(exception.getMessage())) {
            Log.d(TAG, exception.getMessage());
        } else {
            Log.d(TAG, exception.getMessage());
        }
    }

    public static void exceptionMessage(@NonNull JSONException exception, @NonNull String TAG) {
        if (StringUtils.isNull(exception.getMessage())) {
            Log.d(TAG, exception.getMessage());
        } else {
            Log.d(TAG, exception.getMessage());
        }
    }

    public static void exceptionMessage(@NonNull HttpException exception, @NonNull String TAG) {
        if (StringUtils.isNull(exception.getMessage())) {
            Log.d(TAG, exception.getMessage());
        } else {
            Log.d(TAG, exception.getMessage());
        }
    }

    public static void exceptionMessage(@NonNull NoSuchAlgorithmException exception, @NonNull String TAG) {
        if (StringUtils.isNull(exception.getMessage())) {
            Log.d(TAG, exception.getMessage());
        } else {
            Log.d(TAG, exception.getMessage());
        }
    }


}
