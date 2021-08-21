package com.pls.spojenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;

public class Sestka_a extends AppCompatActivity {

    Button SA103,SA104,SA01,SA05;
    String SestkaAHodina,SestkaAMiestnost1,SestkaAMiestnost2;
    ConstraintLayout mConstraintLayoutGallery;
    AnimationDrawable mAnimationDrawableGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sestka_a);

        SA103 = findViewById(R.id.SA103);
        SA104 = findViewById(R.id.SA104);
        SA01 = findViewById(R.id.SA01);
        SA05 = findViewById(R.id.SA05);
        mConstraintLayoutGallery = findViewById(R.id.sestkaA);

        mAnimationDrawableGallery = (AnimationDrawable) mConstraintLayoutGallery.getBackground();

        mAnimationDrawableGallery.setEnterFadeDuration(2000);
        mAnimationDrawableGallery.setExitFadeDuration(4000);
        mAnimationDrawableGallery.start();


        Bundle extras = getIntent().getExtras();

        if (extras.getString("hodina") != null) {
            SestkaAHodina = extras.getString("hodina");

            switch (SestkaAHodina){
                case "SA103": SA103.setBackgroundColor(Color.YELLOW);break;
                case "SA104": SA104.setBackgroundColor(Color.YELLOW);break;
                case "SA01": SA01.setBackgroundColor(Color.YELLOW);break;
                case "SA05": SA05.setBackgroundColor(Color.YELLOW);break;
                default:break;

            }


        }  else if (extras.getString("miestnost1") != null) {
            SestkaAMiestnost1 = extras.getString("miestnost1");
            SestkaAMiestnost2 = extras.getString("miestnost2");

            assert SestkaAMiestnost1 != null;
            switch (SestkaAMiestnost1){
                case "SA103": SA103.setBackgroundColor(Color.YELLOW);break;
                case "SA104": SA104.setBackgroundColor(Color.YELLOW);break;
                case "SA01": SA01.setBackgroundColor(Color.YELLOW);break;
                case "SA05": SA05.setBackgroundColor(Color.YELLOW);break;
                default: break;

            }

            assert SestkaAMiestnost2 != null;
            switch (SestkaAMiestnost2){
                case "SA103": SA103.setBackgroundColor(Color.YELLOW);break;
                case "SA104": SA104.setBackgroundColor(Color.YELLOW);break;
                case "SA01": SA01.setBackgroundColor(Color.YELLOW);break;
                case "SA05": SA05.setBackgroundColor(Color.YELLOW);break;
                default: break;

            }
        }






    }
}