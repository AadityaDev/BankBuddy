package com.technawabs.bankbuddy.services;

import android.util.Log;

import com.aditya.edforaapp.concurrency.ExecutorUtils;
import com.aditya.edforaapp.constants.AppAPI;
import com.aditya.edforaapp.constants.AppConstant;
import com.aditya.edforaapp.network.RequestGenerator;
import com.aditya.edforaapp.network.RequestHandler;
import com.aditya.edforaapp.utils.StringUtils;
import com.google.common.util.concurrent.ListenableFuture;

import org.json.JSONArray;

import java.util.concurrent.Callable;

import okhttp3.Request;

public class SongService {

    private final String TAG = this.getClass().getSimpleName();

    public ListenableFuture<JSONArray> getSongs() {
        return ExecutorUtils.getBackgroundPool().submit(new Callable<JSONArray>() {
            @Override
            public JSONArray call() throws Exception {
                Request request = RequestGenerator.get(AppAPI.SONGS_URL);
                Log.d(TAG, request.toString());
                String result = RequestHandler.makeRequestAndValidate(request);
                Log.d(TAG, result);
                JSONArray score = new JSONArray(result);
                try {
                    Log.d(TAG, score.toString());
                } catch (Exception exception) {
                    if ((exception != null) && (!StringUtils.isNull(exception.getMessage()))) {
                        Log.d(TAG, exception.getMessage());
                    } else {
                        Log.d(TAG, AppConstant.EXCEPTION.EXCEPTION);
                    }
                } finally {
                    return score;
                }
            }
        });
    }
}
