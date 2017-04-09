package com.technawabs.bankbuddy.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.technawabs.bankbuddy.R;
import com.technawabs.bankbuddy.fragments.FingerprintScanner;
import com.technawabs.bankbuddy.fragments.ImageFragment;
import com.technawabs.bankbuddy.views.uicomponents.PagerTabWidget;

import java.util.List;

public class SignInActivity extends BaseActivity implements FingerprintScanner.OnFragmentInteractionListener{

    List<String> list;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private PagerTabWidget pagerTabWidget;
    private ViewPager viewPager;
    private PagerTabAdapter pagerTabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initTabWidget();
        Log.d(getTAG(), "SignIn");
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        FingerprintScanner fingerprintScanner = new FingerprintScanner();
        fragmentTransaction.replace(R.id.frame, fingerprintScanner);
        fragmentTransaction.commit();
//        startActivity(new Intent(getApplicationContext(),FingerprintScanner.class));
    }

    private void initTabWidget() {
        pagerTabWidget = (PagerTabWidget) findViewById(R.id.tabWidget);
        pagerTabWidget.setDividerInvisible();
        pagerTabWidget.addTab(LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_bar_contact, null));
        pagerTabWidget.addTab(LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_bar_engage, null));
        pagerTabWidget.addTab(LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_bar_job, null));

        viewPager = (ViewPager) findViewById(R.id.tabViewPager);
        pagerTabAdapter = new PagerTabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerTabAdapter);

        pagerTabWidget.setmViewPager(viewPager);
        pagerTabWidget.setmOnTabSelectedListener(new PagerTabWidget.OnTabSelectedListener() {
            @Override
            public void onSelected(List<View> tabViews, int position) {
                Toast.makeText(getApplicationContext(), "Here: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

//    @Override
//    public void onFragmentInteraction(Uri uri) {
//
//    }
}

class PagerTabAdapter extends FragmentPagerAdapter {

    public PagerTabAdapter(@NonNull FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return ImageFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}