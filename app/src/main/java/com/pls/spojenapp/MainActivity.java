package com.pls.spojenapp;

import android.annotation.SuppressLint;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.RequiresApi;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements DrawerTiltoCucc {

    private AppBarConfiguration mAppBarConfiguration;
    TextView ora;
    View hview;
    CountDownTimer mCountDownTimer;
    CountDownTimer mCountDownTimer2;
    long timeLeftInMillIseconds = 1;  /*600000*/;
    String presnyCas;
    int presnyCasInterger;
    int teszt = 0;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch skrat;
    Boolean SwitchState = true;
    TextView proba;
    Button resetatallit;
    String hodina ;
    String szunet;
    DrawerLayout drawer;







    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(


                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.blankFragment,R.id.bufet)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
          NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
          NavigationUI.setupWithNavController(navigationView, navController);

          hview =navigationView.getHeaderView(0);
          ora = hview.findViewById(R.id.textView2);
          skrat = hview.findViewById(R.id.switch2);



       // drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

           startTime();




         hodina = this.getString(R.string.óra) ;
         szunet = this.getString( R.string.szünet);
          skrat.setText(R.string.normalis);






           skrat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                   if (isChecked){
                       timeLeftInMillIseconds = 1;
                       mCountDownTimer.cancel();
                       startTime2();
                       skrat.setText(R.string.roviditett);

                   }
                   else{
                       timeLeftInMillIseconds = 1;
                       mCountDownTimer2.cancel();
                       startTime();
                       skrat.setText(R.string.normalis);
                   }
               }
           });


    }

    public void startTime (){


        mCountDownTimer = new CountDownTimer(timeLeftInMillIseconds,1000) {
            @Override
            public void onTick(long millisUntilFinished) {


                timeLeftInMillIseconds = millisUntilFinished;





                updateTimer();

            }



            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onFinish() {

                updateTime();
                startTime();




            }
        }.start();


    }


    public void updateTimer(){

        int minutes = (int) timeLeftInMillIseconds / 60000;
        int seconds = (int) timeLeftInMillIseconds % 60000 / 1000;

        String timeLeftText;



        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if(seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;


        if(skrat.isChecked()){

            if (presnyCasInterger >= 72500 && presnyCasInterger <= 75500){
                timeLeftText += " - 0." + hodina;
            }
            else if (presnyCasInterger >= 75500 && presnyCasInterger <= 80000){
                timeLeftText += " - " + szunet;
            }
            else if (presnyCasInterger >= 80000 && presnyCasInterger <= 83000) {
                timeLeftText += " - 1." + hodina;
            }
            else if (presnyCasInterger >= 83000 && presnyCasInterger <= 83500){
                timeLeftText += " - " + szunet;
            }
            else if (presnyCasInterger >= 83500 && presnyCasInterger <= 90500){
                timeLeftText += " - 2." + hodina;
            }
            else if (presnyCasInterger >= 90500 && presnyCasInterger <= 91000){
                timeLeftText += " - " + szunet;
            }
            else if (presnyCasInterger >= 91000 && presnyCasInterger <= 94000){
                timeLeftText += " - 3." + hodina;
            }
            else if (presnyCasInterger >= 94000 && presnyCasInterger <= 94500){
                timeLeftText += " - " + szunet;
            }
            else if (presnyCasInterger >= 94500 && presnyCasInterger <= 101500){
                timeLeftText += " - 4." + hodina;
            }
            else if (presnyCasInterger >= 101500 && presnyCasInterger <= 102000){
                timeLeftText += " - " + szunet;
            }
            else if (presnyCasInterger >= 102000 && presnyCasInterger <= 105000){
                timeLeftText += " - 5." + hodina;
            }
            else if (presnyCasInterger >= 105000 && presnyCasInterger <= 105500){
                timeLeftText += " - " + szunet;
            }
            else if (presnyCasInterger >= 105500 && presnyCasInterger <= 112500){
                timeLeftText += " - 6." + hodina;
            }
            else if (presnyCasInterger >= 112500 && presnyCasInterger <= 113000){
                timeLeftText += " - " + szunet;
            }
            else if (presnyCasInterger >= 113000 && presnyCasInterger <= 120000){
                timeLeftText += " - 7." + hodina;
            }
            else if (presnyCasInterger >= 120000 && presnyCasInterger <= 120500){
                timeLeftText += " - " + szunet;
            }
            else if (presnyCasInterger >= 120500 && presnyCasInterger <= 123500){
                timeLeftText += " - 8." + hodina;
            }
            else{timeLeftText = getString(R.string.nincsTanitas);}

        }
        else {

            if (presnyCasInterger >= 70500 && presnyCasInterger <= 75000){
                timeLeftText += " - 0."  + hodina;
            }
            else if (presnyCasInterger >= 75000 && presnyCasInterger <=75500 ){
                timeLeftText += " - " + szunet;
            }
            else if (presnyCasInterger >= 75500 && presnyCasInterger <= 84000) {
                timeLeftText += " - 1." + hodina;
            }
            else if (presnyCasInterger >= 84000 && presnyCasInterger <= 85000){
                timeLeftText += " - " + szunet;
            }
            else if (presnyCasInterger >= 85000 && presnyCasInterger <= 93500){
                timeLeftText += " - 2." + hodina;
            }
            else if (presnyCasInterger >= 93500 && presnyCasInterger <= 94500){
                timeLeftText += " - " + szunet;
            }
            else if (presnyCasInterger >= 94500 && presnyCasInterger <= 103000){
                timeLeftText += " - 3." + hodina;
            }
            else if (presnyCasInterger >= 103000 && presnyCasInterger <= 104000){
                timeLeftText += " - " + szunet;
            }
            else if (presnyCasInterger >= 104000 && presnyCasInterger <= 112500){
                timeLeftText += " - 4." + hodina;
            }
            else if (presnyCasInterger >= 112500 && presnyCasInterger <= 113000){
                timeLeftText += " - " + szunet;
            }
            else if (presnyCasInterger >= 113000 && presnyCasInterger <= 121500){
                timeLeftText += " - 5." + hodina;
            }
            else if (presnyCasInterger >= 121500 && presnyCasInterger <= 124500){
                timeLeftText += " - " + szunet;
            }
            else if (presnyCasInterger >= 124500 && presnyCasInterger <= 133000){
                timeLeftText += " - 6." + hodina;
            }
            else if (presnyCasInterger >= 133000 && presnyCasInterger <= 133500){
                timeLeftText += " - " + szunet;
            }
            else if (presnyCasInterger >= 133500 && presnyCasInterger <= 142000){
                timeLeftText += " - 7." + hodina;
            }
            else if (presnyCasInterger >= 142000 && presnyCasInterger <= 142500){
                timeLeftText += " - " + szunet;
            }
            else if (presnyCasInterger >= 142500 && presnyCasInterger <= 151000){
                timeLeftText += " - 8." + hodina;
            }
            else{ timeLeftText = getString(R.string.nincsTanitas);}

        }

        ora.setText(timeLeftText);

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void updateTime(){

        timeLeftInMillIseconds = 1;

        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
        Date date = new Date();

        if(skrat.isChecked()){

            presnyCas = formatter.format(date);

            presnyCasInterger = Integer.parseInt(presnyCas);


            if (presnyCasInterger >= 72500 && presnyCasInterger <= 75500) {
                timeLeftInMillIseconds = (75500 - presnyCasInterger) * 600;
            }else if (presnyCasInterger >= 75500 && presnyCasInterger <= 80000) {
                timeLeftInMillIseconds = (80000 - presnyCasInterger) * 600;
            }else if (presnyCasInterger >= 80000 && presnyCasInterger <= 83000) {
                timeLeftInMillIseconds = (83000 - presnyCasInterger) * 600;
            }else if (presnyCasInterger >= 83000 && presnyCasInterger <= 83500) {
                timeLeftInMillIseconds = (83500 - presnyCasInterger) * 600;
            }else if (presnyCasInterger >=90000  && presnyCasInterger <=90500 ) {
                timeLeftInMillIseconds = (90500 - presnyCasInterger) * 600;
            }else if (presnyCasInterger >= 83500 && presnyCasInterger <= 90500) {
                timeLeftInMillIseconds = (90500 - presnyCasInterger - 4000) * 600;
            }else if (presnyCasInterger >= 90500 && presnyCasInterger <= 91000) {
                timeLeftInMillIseconds = (91000 - presnyCasInterger) * 600;
            }else if (presnyCasInterger >= 91000 && presnyCasInterger <= 94000) {
                timeLeftInMillIseconds = (94000 - presnyCasInterger) * 600;
            }else if (presnyCasInterger >= 94000 && presnyCasInterger <= 94500) {
                timeLeftInMillIseconds = (94500 - presnyCasInterger) * 600;
            }else if (presnyCasInterger >= 100000 && presnyCasInterger <= 101500) {
                timeLeftInMillIseconds = (101500 - presnyCasInterger) * 600;
            }else if (presnyCasInterger >= 94500 && presnyCasInterger <= 101500) {
                timeLeftInMillIseconds = (101500 - presnyCasInterger - 4000) * 600;
            }else if (presnyCasInterger >= 101500 && presnyCasInterger <= 102000) {
                timeLeftInMillIseconds = (102000 - presnyCasInterger) * 600;
            }else if (presnyCasInterger >= 102000 && presnyCasInterger <= 105000) {
                timeLeftInMillIseconds = (105000 - presnyCasInterger) * 600;
            }else if (presnyCasInterger >= 105000 && presnyCasInterger <= 105500) {
                timeLeftInMillIseconds = (105500 - presnyCasInterger) * 600;
            }else if (presnyCasInterger >= 110000 && presnyCasInterger <= 112500) {
                timeLeftInMillIseconds = (112500 - presnyCasInterger) * 600;
            }else if (presnyCasInterger >= 105500 && presnyCasInterger <= 112500) {
                timeLeftInMillIseconds = (112500 - presnyCasInterger - 4000) * 600;
            }else if (presnyCasInterger >= 112500 && presnyCasInterger <= 113000) {
                timeLeftInMillIseconds = (113000 - presnyCasInterger) * 600;
            }else if (presnyCasInterger >= 113000 && presnyCasInterger <= 120000) {
                timeLeftInMillIseconds = (120000 - presnyCasInterger) * 600;
            }else if (presnyCasInterger >= 120000 && presnyCasInterger <= 120500) {
                timeLeftInMillIseconds = (120500 - presnyCasInterger) * 600;
            }else if (presnyCasInterger >= 120500 && presnyCasInterger <= 123500) {
                timeLeftInMillIseconds = (123500 - presnyCasInterger) * 600;
            }
            else{
                timeLeftInMillIseconds = 60000;
            }


        }

        else {

            presnyCas = formatter.format(date);

            presnyCasInterger = Integer.parseInt(presnyCas);


            if (presnyCasInterger >= 70500 && presnyCasInterger <= 75000) {
                timeLeftInMillIseconds = (75000 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 75000 && presnyCasInterger <= 75500) {
                timeLeftInMillIseconds = (75500 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 80000 && presnyCasInterger <= 84000) {
                timeLeftInMillIseconds = (84000 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 75500 && presnyCasInterger <= 84000) {
                timeLeftInMillIseconds = (84000 - presnyCasInterger - 4000) * 600;
            } else if (presnyCasInterger >= 84000 && presnyCasInterger <= 85000) {
                timeLeftInMillIseconds = (85000 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 90000 && presnyCasInterger <= 93500) {
                timeLeftInMillIseconds = (93500 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 85000 && presnyCasInterger <= 93500) {
                timeLeftInMillIseconds = (93500 - presnyCasInterger - 4000) * 600;
            } else if (presnyCasInterger >= 93500 && presnyCasInterger <= 94500) {
                timeLeftInMillIseconds = (94500 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 100000 && presnyCasInterger <= 103000) {
                timeLeftInMillIseconds = (103000 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 94500 && presnyCasInterger <= 103000) {
                timeLeftInMillIseconds = (103000 - presnyCasInterger - 4000) * 600;
            } else if (presnyCasInterger >= 103000 && presnyCasInterger <= 104000) {
                timeLeftInMillIseconds = (104000 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 110000 && presnyCasInterger <= 112500) {
                timeLeftInMillIseconds = (112500 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 104000 && presnyCasInterger <= 112500) {
                timeLeftInMillIseconds = (112500 - presnyCasInterger - 4000) * 600;
            } else if (presnyCasInterger >= 112500 && presnyCasInterger <= 113000) {
                timeLeftInMillIseconds = (113000 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 120000 && presnyCasInterger <= 121500) {
                timeLeftInMillIseconds = (121500 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 113000 && presnyCasInterger <= 121500) {
                timeLeftInMillIseconds = (121500 - presnyCasInterger - 40000) * 600;
            } else if (presnyCasInterger >= 121500 && presnyCasInterger <= 124500) {
                timeLeftInMillIseconds = (124500 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 130000 && presnyCasInterger <= 133000) {
                timeLeftInMillIseconds = (133000 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 124500 && presnyCasInterger <= 133000) {
                timeLeftInMillIseconds = (133000 - presnyCasInterger - 4000) * 600;
            } else if (presnyCasInterger >= 133000 && presnyCasInterger <= 133500) {
                timeLeftInMillIseconds = (133500 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 140000 && presnyCasInterger <= 142000) {
                timeLeftInMillIseconds = (142000 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 133500 && presnyCasInterger <= 142000) {
                timeLeftInMillIseconds = (142000 - presnyCasInterger - 4000) * 600;
            } else if (presnyCasInterger >= 142000 && presnyCasInterger <= 142500) {
                timeLeftInMillIseconds = (142500 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 150000 && presnyCasInterger <= 151000) {
                timeLeftInMillIseconds = (151000 - presnyCasInterger) * 600;
            } else if (presnyCasInterger >= 142500 && presnyCasInterger <= 151000) {
                timeLeftInMillIseconds = (151000 - presnyCasInterger - 4000) * 600;
            }
            else{
                timeLeftInMillIseconds = 60000;
            }

        }

    }

    public void startTime2 (){


        mCountDownTimer2 = new CountDownTimer(timeLeftInMillIseconds,1000) {
            @Override
            public void onTick(long millisUntilFinished) {


                timeLeftInMillIseconds = millisUntilFinished;


                updateTimer();

            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onFinish() {

                updateTime();
                startTime2();

            }
        }.start();


    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       //  Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    @Override
    public boolean onSupportNavigateUp() {
         NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
           return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                 || super.onSupportNavigateUp();






    }


    @Override
    public void setDrawer_Locked() {

        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

    }

    @Override
    public void setDrawer_UnLocked() {

        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

    }
}

