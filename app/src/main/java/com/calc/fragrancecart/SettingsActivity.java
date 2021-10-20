package com.calc.fragrancecart;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SettingsActivity extends AppCompatActivity {

    // Ui widgets
    private Toolbar mToolbar;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Finding UI widgets
        mToolbar = findViewById(R.id.settings_toolbar);
        setSupportActionBar(mToolbar);

        // Setting up action bar
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setTitle(getResources().getString(R.string.settings_title));
        mActionBar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_chevron_left_black_24dp));

    }
}