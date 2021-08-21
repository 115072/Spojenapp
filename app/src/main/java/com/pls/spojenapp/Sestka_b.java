package com.pls.spojenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;

public class Sestka_b extends AppCompatActivity {

    Button SB08,SB05,SB106,SB107;
    String SestkaBHodina,SestkaBMiestnost1,SestkaBMiestnost2;
    ConstraintLayout mConstraintLayoutGallery;
    AnimationDrawable mAnimationDrawableGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sestka_b);

        SB08 = findViewById(R.id.SB08);
        SB05 = findViewById(R.id.SB05);
        SB106 = findViewById(R.id.SB106);
        SB107 = findViewById(R.id.SB107);
        mConstraintLayoutGallery = findViewById(R.id.sestkaB);

        mAnimationDrawableGallery = (AnimationDrawable) mConstraintLayoutGallery.getBackground();

        mAnimationDrawableGallery.setEnterFadeDuration(2000);
        mAnimationDrawableGallery.setExitFadeDuration(4000);
        mAnimationDrawableGallery.start();

        Bundle extras = getIntent().getExtras();

        if (extras.getString("hodina") != null) {
            SestkaBHodina = extras.getString("hodina");

            switch (SestkaBHodina){
                case "SB08" : SB08.setBackgroundColor(Color.YELLOW);break;
                case "SB05" : SB05.setBackgroundColor(Color.YELLOW);break;
                case "SB106" : SB106.setBackgroundColor(Color.YELLOW);break;
                case "SB107" : SB107.setBackgroundColor(Color.YELLOW);break;
                default:break;

            }


        }  else if (extras.getString("miestnost1") != null) {
            SestkaBMiestnost1 = extras.getString("miestnost1");
            SestkaBMiestnost2 = extras.getString("miestnost2");

            assert SestkaBMiestnost1 != null;
            switch (SestkaBMiestnost1){
                case "SB08" : SB08.setBackgroundColor(Color.YELLOW);break;
                case "SB05" : SB05.setBackgroundColor(Color.YELLOW);break;
                case "SB106" : SB106.setBackgroundColor(Color.YELLOW);break;
                case "SB107" : SB107.setBackgroundColor(Color.YELLOW);break;
                default: break;

            }

            assert SestkaBMiestnost2 != null;
            switch (SestkaBMiestnost2){
                case "SB08" : SB08.setBackgroundColor(Color.YELLOW);break;
                case "SB05" : SB05.setBackgroundColor(Color.YELLOW);break;
                case "SB106" : SB106.setBackgroundColor(Color.YELLOW);break;
                case "SB107" : SB107.setBackgroundColor(Color.YELLOW);break;
                default: break;

            }
        }


    }
}