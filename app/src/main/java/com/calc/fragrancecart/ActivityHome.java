package com.calc.fragrancecart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityHome extends AppCompatActivity {
    //NavigationView nav;
   // ActionBarDrawerToggle toggle;
  //  DrawerLayout drawerLayout;
    Button start_btn_buyer, start_btn_Seller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        start_btn_buyer = findViewById(R.id.start_btn_buyer);
        start_btn_Seller = findViewById(R.id.start_btn_Seller);


        start_btn_buyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityHome.this, StartUserActivity.class);
                startActivity(intent);
            }
        });


        start_btn_Seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityHome.this, RegisterActivity.class);
                startActivity(intent);
            }
        });






        // Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

       // nav=(NavigationView)findViewById(R.id.navmenu);
     //   drawerLayout=(DrawerLayout)findViewById(R.id.drawer);

      /*  toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/

       // getSupportFragmentManager().beginTransaction().replace(R.id.container,new Fragment()).commit();
       // nav.setCheckedItem(R.id.menu_home);

     //   nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

        //    Fragment temp;
           /* public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
                switch (menuItem.getItemId())
                {
                    case R.id.menu_home :
                        temp= new Fragment();
                        break;
                    case R.id.menu_call :
                        temp=new CallFragment();
                        break;
                    case R.id.menu_setting :
                        temp=new SearchFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,temp).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });*/





    }
}
