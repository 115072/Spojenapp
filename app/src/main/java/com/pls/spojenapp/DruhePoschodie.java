package com.pls.spojenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DruhePoschodie extends AppCompatActivity {

    Button F205,F201,F206,F204,F203,chod15;
    String dHodina,dMiestnost1,dMiestnost2;
    ConstraintLayout mConstraintLayout;
    AnimationDrawable mAnimationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_druhe_poschodie);

        F205 = findViewById(R.id.F205);
        F201 = findViewById(R.id.F201);
        F206 = findViewById(R.id.F206);
        F204 = findViewById(R.id.F204);
        F203 = findViewById(R.id.F203);
        chod15 = findViewById(R.id.chod15);

        mConstraintLayout = findViewById(R.id.druhePoschodie);

        mAnimationDrawable = (AnimationDrawable) mConstraintLayout.getBackground();

        mAnimationDrawable.setEnterFadeDuration(2000);
        mAnimationDrawable.setExitFadeDuration(4000);
        mAnimationDrawable.start();






        Bundle extras = getIntent().getExtras();

        if (extras.getString("hodina") != null) {
            dHodina = extras.getString("hodina");

            switch (dHodina){
                case "F205": F205.setBackgroundColor(Color.YELLOW);break;
                case "F201": F201.setBackgroundColor(Color.YELLOW);break;
                case "F206": F206.setBackgroundColor(Color.YELLOW);break;
                case "F204": F204.setBackgroundColor(Color.YELLOW);break;
                case "F203": F203.setBackgroundColor(Color.YELLOW);break;
                default:break;

            }


        }  else if (extras.getString("miestnost1") != null) {
            dMiestnost1 = extras.getString("miestnost1");
            dMiestnost2 = extras.getString("miestnost2");

            assert dMiestnost1 != null;
            switch (dMiestnost1){
                case "F205": F205.setBackgroundColor(Color.YELLOW);break;
                case "F201": F201.setBackgroundColor(Color.YELLOW);break;
                case "F206": F206.setBackgroundColor(Color.YELLOW);break;
                case "F204": F204.setBackgroundColor(Color.YELLOW);break;
                case "F203": F203.setBackgroundColor(Color.YELLOW);break;
                default: break;

            }

            assert dMiestnost2 != null;
            switch (dMiestnost2){
                case "F205": F205.setBackgroundColor(Color.YELLOW);break;
                case "F201": F201.setBackgroundColor(Color.YELLOW);break;
                case "F206": F206.setBackgroundColor(Color.YELLOW);break;
                case "F204": F204.setBackgroundColor(Color.YELLOW);break;
                case "F203": F203.setBackgroundColor(Color.YELLOW);break;
                default: break;

            }
        }


        chod15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DruhePoschodie.this,streetView.class);
                startActivity(intent);

            }
        });



    }


}