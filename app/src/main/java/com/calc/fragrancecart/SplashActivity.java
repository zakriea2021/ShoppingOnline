package com.calc.fragrancecart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

 //   ImageView shopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // shopping = findViewById(R.id.shopping);

      /*  shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this, ActivityHome.class);
                startActivity(intent);

            }
        },3000);
    }
}