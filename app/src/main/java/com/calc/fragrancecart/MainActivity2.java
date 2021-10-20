package com.calc.fragrancecart;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {
    BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportFragmentManager().beginTransaction().replace(R.id.FrameConatiner,new Fragment()).commit();

        bnv=(BottomNavigationView)findViewById(R.id.bottomNavigation);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                Fragment temp=null;

                switch (item.getItemId())
                {
                    case R.id.menu_home : temp=new Fragment();
                        break;
                    case R.id.menu_call : temp=new CallFragment();
                        break;
                    case R.id.menu_search : temp=new SearchFragment();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.FrameConatiner,temp).commit();

                return true;
            }
        });

    }
}
