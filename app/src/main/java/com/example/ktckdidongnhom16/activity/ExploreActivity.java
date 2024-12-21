package com.example.ktckdidongnhom16.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.ktckdidongnhom16.R;
//import com.example.ktckdidongnhom16.adapters.ExploreViewPagerAdapter;
import com.example.ktckdidongnhom16.custom.CustomBottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ExploreActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private CustomBottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

//        tabLayout = findViewById(R.id.tabLayout);
//        viewPager = findViewById(R.id.viewPager);
//
//        setupViewPager();
//        setupTabLayout();

        initializeNavigation();
    }

    private void initializeNavigation() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_home) {
                    startActivity(new Intent(ExploreActivity.this, com.example.appchiasecongthucnauan.activities.HomePageActivity.class));
                    return true;
                } else if (itemId == R.id.navigation_explorer) {
                    return true;
                } else if (itemId == R.id.navigation_profile) {
                    startActivity(new Intent(ExploreActivity.this, SettingsActivity.class));
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (bottomNavigationView != null) {
            bottomNavigationView.setSelectedItemId(R.id.navigation_explorer);
        }
    }
}
