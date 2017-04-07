package com.technawabs.bankbuddy.activities;

import android.os.Bundle;
import android.util.Log;

import com.technawabs.bankbuddy.R;

import java.util.List;

public class SignInActivity extends BaseActivity {

    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Log.d(getTAG(), "SignIn");
    }
}
