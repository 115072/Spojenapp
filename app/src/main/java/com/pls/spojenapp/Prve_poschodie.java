package com.pls.spojenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;

public class Prve_poschodie extends AppCompatActivity {

    Button D108,D107,D106,D1051S1,D1051S2,D102,D101,C101,C102,C1031S3,C1032S4,C106,C107,C108,C109,F103,B110,B109,B108,B107,B106,B102,B101,A101,A102,A106,A107,A108,A109,F107;
    String phodina,pmiestnost1,pmiestnost2;
    ConstraintLayout mConstraintLayout;
    AnimationDrawable mAnimationDrawable;
    String pmiestnost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prve_poschodie);

        D108 = findViewById(R.id.D108);
        D107 = findViewById(R.id.D107);
        D106 = findViewById(R.id.D106);
        D1051S1 = findViewById(R.id.D1051S1);
        D1051S2 = findViewById(R.id.D1052S2);
        D102 = findViewById(R.id.D102);
        D101 = findViewById(R.id.D101);
        C101 = findViewById(R.id.C101);
        C102 = findViewById(R.id.C102);
        C1031S3 = findViewById(R.id.C1031S3);
        C1032S4 = findViewById(R.id.C1032S4);
        C106 = findViewById(R.id.C106);
        C107 = findViewById(R.id.C107);
        C108 = findViewById(R.id.C108);
        C109 = findViewById(R.id.C109);
        F103 = findViewById(R.id.F103);
        B110 = findViewById(R.id.B110);
        B109 = findViewById(R.id.B109);
        B108 = findViewById(R.id.B108);
        B107 = findViewById(R.id.B107);
        B106 = findViewById(R.id.B106);
        B102 = findViewById(R.id.B102);
        B101 = findViewById(R.id.B101);
        A101 = findViewById(R.id.A101);
        A102 = findViewById(R.id.A102);
        A106 = findViewById(R.id.A106);
        A107 = findViewById(R.id.A107);
        A108 = findViewById(R.id.A108);
        A109 = findViewById(R.id.A109);
        F107 = findViewById(R.id.zborovna);

        mConstraintLayout = findViewById(R.id.prvePoschodie);

        mAnimationDrawable = (AnimationDrawable) mConstraintLayout.getBackground();

        mAnimationDrawable.setEnterFadeDuration(2000);
        mAnimationDrawable.setExitFadeDuration(4000);
        mAnimationDrawable.start();


        Bundle extras = getIntent().getExtras();

        if (extras.getString("hodina") != null) {
            phodina = extras.getString("hodina");

            switch (phodina){
                case "D108": D108.setBackgroundColor(Color.YELLOW);break;
                case "D107": D107.setBackgroundColor(Color.YELLOW);break;
                case "D106": D106.setBackgroundColor(Color.YELLOW);break;
                case "D1051S1":D1051S1.setBackgroundColor(Color.YELLOW);break;
                case "D1051S2":D1051S2.setBackgroundColor(Color.YELLOW);break;
                case "D102": D102.setBackgroundColor(Color.YELLOW);break;
                case "D101": D101.setBackgroundColor(Color.YELLOW);break;
                case "C101": C101.setBackgroundColor(Color.YELLOW);break;
                case "C102": C102.setBackgroundColor(Color.YELLOW);break;
                case "C1031S3": C1031S3.setBackgroundColor(Color.YELLOW);break;
                case "C1032S4": C1032S4.setBackgroundColor(Color.YELLOW);break;
                case "C106": C106.setBackgroundColor(Color.YELLOW);break;
                case "C107": C107.setBackgroundColor(Color.YELLOW);break;
                case "C108": C108.setBackgroundColor(Color.YELLOW);break;
                case "C109": C109.setBackgroundColor(Color.YELLOW);break;
                case "F103": F103.setBackgroundColor(Color.YELLOW);break;
                case "B110": B110.setBackgroundColor(Color.YELLOW);break;
                case "B109": B109.setBackgroundColor(Color.YELLOW);break;
                case "B108": B108.setBackgroundColor(Color.YELLOW);break;
                case "B107": B107.setBackgroundColor(Color.YELLOW);break;
                case "B106": B106.setBackgroundColor(Color.YELLOW);break;
                case "B102": B102.setBackgroundColor(Color.YELLOW);break;
                case "B101": B101.setBackgroundColor(Color.YELLOW);break;
                case "A101": A101.setBackgroundColor(Color.YELLOW);break;
                case "A102": A102.setBackgroundColor(Color.YELLOW);break;
                case "A106": A106.setBackgroundColor(Color.YELLOW);break;
                case "A107": A107.setBackgroundColor(Color.YELLOW);break;
                case "A108": A108.setBackgroundColor(Color.YELLOW);break;
                case "A109": A109.setBackgroundColor(Color.YELLOW);break;
                case "F107": F107.setBackgroundColor(Color.YELLOW);break;
                default:break;
            }


        }  else if (extras.getString("miestnost1") != null) {
            pmiestnost1 = extras.getString("miestnost1");
            pmiestnost2 = extras.getString("miestnost2");

            assert pmiestnost1 != null;
            switch (pmiestnost1){
                case "D108": D108.setBackgroundColor(Color.YELLOW);break;
                case "D107": D107.setBackgroundColor(Color.YELLOW);break;
                case "D106": D106.setBackgroundColor(Color.YELLOW);break;
                case "D1051S1":D1051S1.setBackgroundColor(Color.YELLOW);break;
                case "D1051S2":D1051S2.setBackgroundColor(Color.YELLOW);break;
                case "D102": D102.setBackgroundColor(Color.YELLOW);break;
                case "D101": D101.setBackgroundColor(Color.YELLOW);break;
                case "C101": C101.setBackgroundColor(Color.YELLOW);break;
                case "C102": C102.setBackgroundColor(Color.YELLOW);break;
                case "C1031S3": C1031S3.setBackgroundColor(Color.YELLOW);break;
                case "C1032S4": C1032S4.setBackgroundColor(Color.YELLOW);break;
                case "C106": C106.setBackgroundColor(Color.YELLOW);break;
                case "C107": C107.setBackgroundColor(Color.YELLOW);break;
                case "C108": C108.setBackgroundColor(Color.YELLOW);break;
                case "C109": C109.setBackgroundColor(Color.YELLOW);break;
                case "F103": F103.setBackgroundColor(Color.YELLOW);break;
                case "B110": B110.setBackgroundColor(Color.YELLOW);break;
                case "B109": B109.setBackgroundColor(Color.YELLOW);break;
                case "B108": B108.setBackgroundColor(Color.YELLOW);break;
                case "B107": B107.setBackgroundColor(Color.YELLOW);break;
                case "B106": B106.setBackgroundColor(Color.YELLOW);break;
                case "B102": B102.setBackgroundColor(Color.YELLOW);break;
                case "B101": B101.setBackgroundColor(Color.YELLOW);break;
                case "A101": A101.setBackgroundColor(Color.YELLOW);break;
                case "A102": A102.setBackgroundColor(Color.YELLOW);break;
                case "A106": A106.setBackgroundColor(Color.YELLOW);break;
                case "A107": A107.setBackgroundColor(Color.YELLOW);break;
                case "A108": A108.setBackgroundColor(Color.YELLOW);break;
                case "A109": A109.setBackgroundColor(Color.YELLOW);break;
                case "F107": F107.setBackgroundColor(Color.YELLOW);break;
                default:break;
            }

            assert pmiestnost2 != null;
            switch (pmiestnost2){
                case "D108": D108.setBackgroundColor(Color.YELLOW);break;
                case "D107": D107.setBackgroundColor(Color.YELLOW);break;
                case "D106": D106.setBackgroundColor(Color.YELLOW);break;
                case "D1051S1":D1051S1.setBackgroundColor(Color.YELLOW);break;
                case "D1051S2":D1051S2.setBackgroundColor(Color.YELLOW);break;
                case "D102": D102.setBackgroundColor(Color.YELLOW);break;
                case "D101": D101.setBackgroundColor(Color.YELLOW);break;
                case "C101": C101.setBackgroundColor(Color.YELLOW);break;
                case "C102": C102.setBackgroundColor(Color.YELLOW);break;
                case "C1031S3": C1031S3.setBackgroundColor(Color.YELLOW);break;
                case "C1032S4": C1032S4.setBackgroundColor(Color.YELLOW);break;
                case "C106": C106.setBackgroundColor(Color.YELLOW);break;
                case "C107": C107.setBackgroundColor(Color.YELLOW);break;
                case "C108": C108.setBackgroundColor(Color.YELLOW);break;
                case "C109": C109.setBackgroundColor(Color.YELLOW);break;
                case "F103": F103.setBackgroundColor(Color.YELLOW);break;
                case "B110": B110.setBackgroundColor(Color.YELLOW);break;
                case "B109": B109.setBackgroundColor(Color.YELLOW);break;
                case "B108": B108.setBackgroundColor(Color.YELLOW);break;
                case "B107": B107.setBackgroundColor(Color.YELLOW);break;
                case "B106": B106.setBackgroundColor(Color.YELLOW);break;
                case "B102": B102.setBackgroundColor(Color.YELLOW);break;
                case "B101": B101.setBackgroundColor(Color.YELLOW);break;
                case "A101": A101.setBackgroundColor(Color.YELLOW);break;
                case "A102": A102.setBackgroundColor(Color.YELLOW);break;
                case "A106": A106.setBackgroundColor(Color.YELLOW);break;
                case "A107": A107.setBackgroundColor(Color.YELLOW);break;
                case "A108": A108.setBackgroundColor(Color.YELLOW);break;
                case "A109": A109.setBackgroundColor(Color.YELLOW);break;
                case "F107": F107.setBackgroundColor(Color.YELLOW);break;
                default:break;
            }
        }



        //phodina = "";
        //pmiestnost = "";



    }
}