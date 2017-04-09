package com.technawabs.bankbuddy.utils;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.view.View;

public class Utility {

    public static void hideProgressBar(@NonNull View progressBar) {
            progressBar.setVisibility(View.INVISIBLE);
    }

    public static void showProgressBar(@NonNull View progressBar) {
        if (progressBar.getVisibility() == View.INVISIBLE) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    public static void openSecuritySettings(@NonNull Context context) {
        Intent intent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
        context.startActivity(intent);
    }

    public static boolean isSupportedHardware(@NonNull Context context) {
        FingerprintManagerCompat fingerprintManager = FingerprintManagerCompat.from(context);
        return fingerprintManager.isHardwareDetected();
    }

}
