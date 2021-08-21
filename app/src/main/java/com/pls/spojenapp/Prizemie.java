package com.pls.spojenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Prizemie extends AppCompatActivity {

    Button D001,C001,C002,C008,C009,C010,C011,F004,B001,A001,A002,A008,A009,A010,A011,B006;
    String hodina, miestnost1,miestnost2;
    ConstraintLayout mConstraintLayout;
    AnimationDrawable mAnimationDrawable;
    TextView plslegyenjo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prizemie);

        D001 = findViewById(R.id.D001);
        C001 = findViewById(R.id.C001);
        C002 = findViewById(R.id.C002);
        C008 = findViewById(R.id.C008);
        C009 = findViewById(R.id.C009);
        C010 = findViewById(R.id.C010);
        C011 = findViewById(R.id.C011);
        F004 = findViewById(R.id.F004);
        B001 = findViewById(R.id.B001);
        A001 = findViewById(R.id.A001);
        A002 = findViewById(R.id.A002);
        A008 = findViewById(R.id.A008);
        A009 = findViewById(R.id.A009);
        A010 = findViewById(R.id.A010);
        A011 = findViewById(R.id.A011);
        B006 = findViewById(R.id.B006);
        plslegyenjo = findViewById(R.id.textView18);

        mConstraintLayout = findViewById(R.id.prizemie);

        mAnimationDrawable = (AnimationDrawable) mConstraintLayout.getBackground();

        mAnimationDrawable.setEnterFadeDuration(2000);
        mAnimationDrawable.setExitFadeDuration(4000);
        mAnimationDrawable.start();


        Bundle extras = getIntent().getExtras();

            if (extras.getString("hodina") != null) {
                hodina = extras.getString("hodina");

                switch (hodina){
                    case "D001": D001.setBackgroundColor(Color.YELLOW);break;
                    case "C001": C001.setBackgroundColor(Color.YELLOW);break;
                    case "C002": C002.setBackgroundColor(Color.YELLOW);break;
                    case "C008": C008.setBackgroundColor(Color.YELLOW);break;
                    case "C009": C009.setBackgroundColor(Color.YELLOW);break;
                    case "C010": C010.setBackgroundColor(Color.YELLOW);break;
                    case "C011": C011.setBackgroundColor(Color.YELLOW);break;
                    case "F004": F004.setBackgroundColor(Color.YELLOW);break;
                    case "B001": B001.setBackgroundColor(Color.YELLOW);break;
                    case "A001": A001.setBackgroundColor(Color.YELLOW);break;
                    case "A002": A002.setBackgroundColor(Color.YELLOW);break;
                    case "A008": A008.setBackgroundColor(Color.YELLOW);break;
                    case "A009": A009.setBackgroundColor(Color.YELLOW);break;
                    case "A010": A010.setBackgroundColor(Color.YELLOW);break;
                    case "A011": A011.setBackgroundColor(Color.YELLOW);break;
                    case "B006": B006.setBackgroundColor(Color.YELLOW);break;
                    default:break;

                }


            }  else if (extras.getString("miestnost1") != null) {
                miestnost1 = extras.getString("miestnost1");
                miestnost2 = extras.getString("miestnost2");

                assert miestnost1 != null;
                switch (miestnost1){
                    case "D001": D001.setBackgroundColor(Color.YELLOW);break;
                    case "C001": C001.setBackgroundColor(Color.YELLOW);break;
                    case "C002": C002.setBackgroundColor(Color.YELLOW);break;
                    case "C008": C008.setBackgroundColor(Color.YELLOW);break;
                    case "C009": C009.setBackgroundColor(Color.YELLOW);break;
                    case "C010": C010.setBackgroundColor(Color.YELLOW);break;
                    case "C011": C011.setBackgroundColor(Color.YELLOW);break;
                    case "F004": F004.setBackgroundColor(Color.YELLOW);break;
                    case "B001": B001.setBackgroundColor(Color.YELLOW);break;
                    case "A001": A001.setBackgroundColor(Color.YELLOW);break;
                    case "A002": A002.setBackgroundColor(Color.YELLOW);break;
                    case "A008": A008.setBackgroundColor(Color.YELLOW);break;
                    case "A009": A009.setBackgroundColor(Color.YELLOW);break;
                    case "A010": A010.setBackgroundColor(Color.YELLOW);break;
                    case "A011": A011.setBackgroundColor(Color.YELLOW);break;
                    case "B006": B006.setBackgroundColor(Color.YELLOW);break;
                    default: break;

                }

                assert miestnost2 != null;
                switch (miestnost2){
                    case "D001": D001.setBackgroundColor(Color.YELLOW);break;
                    case "C001": C001.setBackgroundColor(Color.YELLOW);break;
                    case "C002": C002.setBackgroundColor(Color.YELLOW);break;
                    case "C008": C008.setBackgroundColor(Color.YELLOW);break;
                    case "C009": C009.setBackgroundColor(Color.YELLOW);break;
                    case "C010": C010.setBackgroundColor(Color.YELLOW);break;
                    case "C011": C011.setBackgroundColor(Color.YELLOW);break;
                    case "F004": F004.setBackgroundColor(Color.YELLOW);break;
                    case "B001": B001.setBackgroundColor(Color.YELLOW);break;
                    case "A001": A001.setBackgroundColor(Color.YELLOW);break;
                    case "A002": A002.setBackgroundColor(Color.YELLOW);break;
                    case "A008": A008.setBackgroundColor(Color.YELLOW);break;
                    case "A009": A009.setBackgroundColor(Color.YELLOW);break;
                    case "A010": A010.setBackgroundColor(Color.YELLOW);break;
                    case "A011": A011.setBackgroundColor(Color.YELLOW);break;
                    case "B006": B006.setBackgroundColor(Color.YELLOW);break;
                    default: break;

                }
            }

//            else if (extras.getString("miestnost2") != null) {
//
//
//
//            }










//        if (extras != null) {
//            if(extras.contains("child"){
//                // that is the intent if from activity1 and contains additional parameters
//
//
//
//            }
//    else{
//
//            }
//        }









      //  hodina = "";
      //  miestnost = "";



    }
}