package com.pls.spojenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;

public class Sestka_c extends AppCompatActivity {

    Button SC108,SC104,SC01,SC02;
    String SestkaCHodina,SestkaCMiestnost1,SestkaCMiestnost2;
    ConstraintLayout mConstraintLayoutGallery;
    AnimationDrawable mAnimationDrawableGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sestka_c);

        SC108 = findViewById(R.id.SC108);
        SC104 = findViewById(R.id.SC104);
        SC01 = findViewById(R.id.SC01);
        SC02 = findViewById(R.id.SC02);
        mConstraintLayoutGallery = findViewById(R.id.sestkaC);

        mAnimationDrawableGallery = (AnimationDrawable) mConstraintLayoutGallery.getBackground();

        mAnimationDrawableGallery.setEnterFadeDuration(2000);
        mAnimationDrawableGallery.setExitFadeDuration(4000);
        mAnimationDrawableGallery.start();

        Bundle extras = getIntent().getExtras();

        if (extras.getString("hodina") != null) {
            SestkaCHodina = extras.getString("hodina");

            assert SestkaCHodina != null;
            switch (SestkaCHodina){
                case "SC108" : SC108.setBackgroundColor(Color.YELLOW);break;
                case "SC104" : SC104.setBackgroundColor(Color.YELLOW);break;
                case "SC01" : SC01.setBackgroundColor(Color.YELLOW);break;
                case "SC02" : SC02.setBackgroundColor(Color.YELLOW);break;
                default:break;

            }


        }  else if (extras.getString("miestnost1") != null) {
            SestkaCMiestnost1 = extras.getString("miestnost1");
            SestkaCMiestnost2 = extras.getString("miestnost2");

            assert SestkaCMiestnost1 != null;
            switch (SestkaCMiestnost1){
                case "SC108" : SC108.setBackgroundColor(Color.YELLOW);break;
                case "SC104" : SC104.setBackgroundColor(Color.YELLOW);break;
                case "SC01" : SC01.setBackgroundColor(Color.YELLOW);break;
                case "SC02" : SC02.setBackgroundColor(Color.YELLOW);break;
                default: break;

            }

            assert SestkaCMiestnost2 != null;
            switch (SestkaCMiestnost2){
                case "SC108" : SC108.setBackgroundColor(Color.YELLOW);break;
                case "SC104" : SC104.setBackgroundColor(Color.YELLOW);break;
                case "SC01" : SC01.setBackgroundColor(Color.YELLOW);break;
                case "SC02" : SC02.setBackgroundColor(Color.YELLOW);break;
                default: break;

            }
        }



    }
}