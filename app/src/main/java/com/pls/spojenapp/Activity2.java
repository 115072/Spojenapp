package com.pls.spojenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends DruhePoschodie {


    Button gomb4;
    String idoSzambanSzoveg;
    int idoSzamban;
    TextView plsMenj;
    String spinnerText;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spojenapp_test);

        gomb4 = findViewById(R.id.button10);
        plsMenj = findViewById(R.id.textView);




        Bundle extras = getIntent().getExtras();

        if(extras!= null){
            idoSzamban = extras.getInt("idoSzamban");

            spinnerText = extras.getString("spinner");





        }

        idoSzambanSzoveg=String.valueOf(idoSzamban);

        plsMenj.setText(spinnerText);

        if (spinnerText.equals("I.DI")){

            gomb4.setBackgroundColor(Color.YELLOW);

        }





















      //  gomb4.setBackgroundColor(Color.YELLOW);
    }




}

