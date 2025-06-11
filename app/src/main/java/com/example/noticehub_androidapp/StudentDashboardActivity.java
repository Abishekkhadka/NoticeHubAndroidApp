package com.example.noticehub_androidapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


/** @noinspection ALL*/
public class StudentDashboardActivity extends AppCompatActivity {


    // Fragment references
    private HomeFragment homeFragment;
    private StudentNoticesFragment noticesFragment;
    private StudentFeedbackFragment feedbackFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Initialize fragments
        homeFragment = new HomeFragment();
        noticesFragment = new StudentNoticesFragment();
        feedbackFragment = new StudentFeedbackFragment();
        profileFragment = new ProfileFragment();

        // Set default fragment
        setCurrentFragment(homeFragment);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                setCurrentFragment(homeFragment);
            } else if (itemId == R.id.nav_notices) {
                setCurrentFragment(noticesFragment);
            } else if (itemId == R.id.nav_feedback) {
                setCurrentFragment(feedbackFragment);
            } else if (itemId == R.id.nav_profile) {
                setCurrentFragment(profileFragment);
            } else {
                return false;
            }
            return true;
        });
    }

    private void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
    }
}