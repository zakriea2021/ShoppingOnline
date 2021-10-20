package com.calc.fragrancecart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import com.example.shopping.R;

//import butterknife.BindView;
//import butterknife.ButterKnife;

public class StartUserActivity extends AppCompatActivity {

 //   @BindView(R.id.btn_main_signup) MaterialButton signup;
 //   @BindView(R.id.tv_main_signin)
 Button btn_main_signup;
  TextView tv_main_signin;

    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_user);
      //  ButterKnife.bind(this);

        btn_main_signup = findViewById(R.id.btn_main_signup);
        tv_main_signin = findViewById(R.id.tv_main_signin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Intent intent=new Intent(StartUserActivity.this, login_activity.class);
                Intent intent=new Intent(StartUserActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        btn_main_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  Intent intent1=new Intent(StartUserActivity.this, RegisterActivity.class);
                Intent intent1=new Intent(StartUserActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });


    }
}