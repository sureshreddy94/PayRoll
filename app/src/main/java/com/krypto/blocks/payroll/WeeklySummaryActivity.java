package com.krypto.blocks.payroll;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.krypto.blocks.payroll.fragments.DailyTotalFragment;
import com.krypto.blocks.payroll.fragments.PayPeriodFragment;
import com.krypto.blocks.payroll.fragments.WeeklyTotalFragment;

import java.util.ArrayList;
import java.util.List;

public class WeeklySummaryActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar_weekly_summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_summary);
        toolbar_weekly_summary = findViewById(R.id.toolbar_weekly_summary);
        initToolBar();
        toolbar_weekly_summary.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar_weekly_summary.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WeeklySummaryActivity.this,JobCompletionReportActivity.class);
                startActivity(i);


            }
        });
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new WeeklyTotalFragment(), "Weekly");
        adapter.addFragment(new DailyTotalFragment(), "Daily");
        adapter.addFragment(new PayPeriodFragment(), "Pay Period");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }


        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    public void initToolBar() {

        //  toolbar_bitcoin = findViewById(R.id.toolbar_bit);
        toolbar_weekly_summary.setTitle(R.string.toolbar_for_summary);
        toolbar_weekly_summary.setTitleTextColor(getResources().getColor(R.color.white));
        //setSupportActionBar(toolbar_bitcoin);

    }
}

