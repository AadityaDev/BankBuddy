package com.technawabs.bankbuddy.activities;

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
import com.technawabs.bankbuddy.fragments.ImageFragment;
import com.technawabs.bankbuddy.views.uicomponents.PagerTabWidget;

import java.util.List;

public class SignInActivity extends BaseActivity {

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
    }

    private void initTabWidget() {
        pagerTabWidget = (PagerTabWidget) findViewById(R.id.home_tabWidget);
        pagerTabWidget.setDividerInvisible();
        pagerTabWidget.addTab(LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_bar_contact, null));
        pagerTabWidget.addTab(LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_bar_engage, null));
        pagerTabWidget.addTab(LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_bar_job, null));

        viewPager = (ViewPager) findViewById(R.id.main_viewPager);
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