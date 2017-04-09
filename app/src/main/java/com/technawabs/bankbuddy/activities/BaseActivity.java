package com.technawabs.bankbuddy.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected String getTAG() {
        return TAG;
    }

    //    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//
//    @Override
//    public void onActivityReenter(int resultCode, Intent data) {
//        super.onActivityReenter(resultCode, data);
//    }
//
//    @Override
//    protected void onResumeFragments() {
//        super.onResumeFragments();
//    }
//
//    @Override
//    protected void onPostResume() {
//        super.onPostResume();
//    }
//
//    @Override
//    public void onAttachFragment(Fragment fragment) {
//        super.onAttachFragment(fragment);
//    }
//
}
