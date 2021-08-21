package com.pls.spojenapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.logging.Logger;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Mapa#newInstance} factory method to
 * create an instance of this fragment.
 */


public class Mapa extends Fragment implements ExampleDialog.ExampleDialogListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Mapa() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mapa.
     */
    // TODO: Rename and change types and number of parameters
    public static Mapa newInstance(String param1, String param2) {
        Mapa fragment = new Mapa();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    Button madarka,cso,cso2;
    ConstraintLayout hatter;
    ConstraintLayout.LayoutParams hattter;
    CountDownTimer ido,ugras;
    long timeLeftInMili = 3100;
    long ugrasido = 100;
    Timer teszt;
    Random rand;
   float density;
    boolean szoj;
    boolean plsMenj2;
    ConstraintLayout.LayoutParams params,params2,params3;
    int madarkaxkezdet,madarkaxvegzet,madarkaytop,madarkaybottom,csoxkezdet,csoytop,csoxvegzet,cso2xkezdet,cso2ybottom,cso2xvegzet;
    int counter = 0,elkuldess = 0;
    TextView szamlalo,szkore;
    Button restart,elkuldes;
    ConstraintLayout vesztettel;
    EditText nev;
    CollectionReference collectionReference;
    final int DP = (int) Resources.getSystem().getDisplayMetrics().density;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    DisplayMetrics displayMetrics;
    int height;
    int[] csopoziciok;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View root = inflater.inflate(R.layout.fragment_mapa, container, false);




        madarka = root.findViewById(R.id.button196);
        hatter = root.findViewById(R.id.hatter);
        cso = root.findViewById(R.id.button197);
        cso2 = root.findViewById(R.id.button198);
        density = requireContext().getResources().getDisplayMetrics().density;
       params = (ConstraintLayout.LayoutParams) cso.getLayoutParams();
       params2 = (ConstraintLayout.LayoutParams) cso2.getLayoutParams();
       params3 = (ConstraintLayout.LayoutParams) madarka.getLayoutParams();
     //  hattter = (ConstraintLayout.LayoutParams) hatter.getLayoutParams();
       szamlalo = root.findViewById(R.id.textView70);
       vesztettel = root.findViewById(R.id.sotetKep);
       restart = root.findViewById(R.id.button200);
       szkore = root.findViewById(R.id.textView71);
       elkuldes = root.findViewById(R.id.button201);
       nev = root.findViewById(R.id.editTextTextPersonName);


         displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
         height = displayMetrics.heightPixels;



        height = height - 75;

        Log.d("asd",String.valueOf(height));

      /*  params3.height = height/15;
        params3.width = height/15;
        madarka.setLayoutParams(params3);

       */







        collectionReference = db.collection("flappyBPontok");

       vesztettel.setVisibility(View.GONE);



        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder
                .setTitle(R.string.dialogcim)
                .setPositiveButton(R.string.igen, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        start();
                    }
                })
                .setCancelable(false)
                .setView(R.layout.alertdialog_kep);


        builder.show();


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        cso.setX(1200);
                        cso2.setX(1200);
                        counter=0;
                        szamlalo.setText(String.valueOf(counter));
                madarka.setVisibility(View.VISIBLE);
                cso.setVisibility(View.VISIBLE);
                cso2.setVisibility(View.VISIBLE);
                vesztettel.setVisibility(View.GONE);
                hatter.setClickable(true);
                elkuldess = 0;
                        start();


            }
        });

        elkuldes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emberNeve = String.valueOf(nev.getText());
                if(counter == 0){
                    Toast.makeText(getContext(), R.string.nullapont, Toast.LENGTH_SHORT).show();
                }
                else if(emberNeve.equals("")){
                    Toast.makeText(getContext(), R.string.nevBeadasa, Toast.LENGTH_SHORT).show();
                }
                else if(emberNeve.length() > 24){
                    Toast.makeText(getContext(), R.string.max24kar, Toast.LENGTH_SHORT).show();
                    nev.setText("");
                }
                else if (elkuldess == 1){
                    Toast.makeText(getContext(), R.string.kuldes_egyszer, Toast.LENGTH_SHORT).show();
                }
                else{
                    elkuldess = 1;
                    addThought(emberNeve,counter);
                    Intent intent = new Intent( getContext(), FlappyBirdLista.class);
                    startActivity(intent);
                    /*counter = 0;
                    szkore.setText(getText(R.string.points ) + ": " + (String.valueOf(counter)));

                     */

                }




            }
        });



        madarka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


        hatter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                ugras = new CountDownTimer(ugrasido,10) {
                    @Override
                    public void onTick(long l) {

                        madarka.setY(madarka.getY()-30);

                    }

                    @Override
                    public void onFinish() {

                    }
                }.start();



              /*  for(int i=0;i<100000;i++){

                    if(i%10000==0){
                        madarka.setY(madarka.getY()-20);
                    }

                }*/

            }
        });


        return root;
    }


    public void start(){

        ido = new CountDownTimer(timeLeftInMili,10) {
            @Override
            public void onTick(long l) {

                cso.setX(cso.getX()- 5);
                cso2.setX( cso2.getX()- 5);


                madarkaytop = (int) madarka.getY();
                madarkaybottom = (int) madarka.getY() + madarka.getHeight();
                csoxkezdet = (int) cso.getX();
                csoxvegzet = (int) cso.getX() + cso.getWidth();
                cso2xvegzet = (int) cso2.getX() + cso2.getWidth();
                csoytop = (int) cso.getY() ;
                cso2xkezdet = (int) cso2.getX();
                cso2ybottom = (int) cso2.getY() + cso2.getHeight();
                madarkaxkezdet = (int) madarka.getX();
                madarkaxvegzet = (int) madarka.getX() + madarka.getWidth();





                if(madarkaytop < 0){

                    ido.cancel();
                    ezVanHaVeszetttel();
                    madarka.setY(madarka.getY()+200);


                }
                else if (madarkaytop > (int) cso.getY() + cso.getHeight() ){

                    ido.cancel();
                    ezVanHaVeszetttel();
                    madarka.setY(madarka.getY()-200);
                }

              else if(madarkaxvegzet == csoxkezdet && madarkaytop > csoytop){

                    ido.cancel();
                    ezVanHaVeszetttel();
               //     Log.d("asd","madarkavegzet es csoxkezdet");
                }

                else if(madarkaxvegzet == cso2xkezdet && madarkaytop < cso2ybottom){

                    ido.cancel();
                    ezVanHaVeszetttel();

                   // Log.d("asd","madarkavegzet es cso2xkezdet");
                }

               else if(madarkaytop <= cso2ybottom && madarkaxkezdet > cso2xkezdet && madarkaxkezdet < cso2xvegzet) {
                        ido.cancel();
                    ezVanHaVeszetttel();
                     //   Log.d("asd", "madarkatop es cso2ybottom");
                     //   cso.setText(String.valueOf(madarkaytop));
                       // cso2.setText(String.valueOf(cso2ybottom));
                    }


                else if(madarkaybottom >= csoytop && madarkaxkezdet > csoxkezdet && madarkaxvegzet < csoxvegzet){
                    ido.cancel();
                    ezVanHaVeszetttel();
                    //Log.d("asd","madarkabottom es csoytop");
                }








                if (cso.getX() < -250){

                    params.height = 0;
                    params2.height = 0;

                    cso.setLayoutParams(params);
                    cso2.setLayoutParams(params2);

                    int szam = 0;
                    while(szam%3==0) {
                        rand = new Random();
                        szam = rand.nextInt(height/2);
                    }
                    if (!szoj){

                        params.height = szam ;
                        cso.setLayoutParams(params);
                       // cso.setHeight(szam/DP);

                    /*  if (szam >0 && szam <301){

                            cso2.setHeight(rand.nextInt((1500 - 1200) + 1200)/DP);
                            //cso2.setLayoutParams(params2);
                        }
                        else if(szam >300 && szam <601){

                            cso2.setHeight(rand.nextInt((1200 - 900) + 900)/DP);
                           // cso2.setLayoutParams(params2);
                        }
                        else if(szam >600 && szam <901){
                            cso2.setHeight(rand.nextInt((900-600) + 600)/DP) ;
                            //cso2.setLayoutParams(params2);
                        }
                        else if(szam >900 && szam <1201){
                            cso2.setHeight(rand.nextInt((600-300) + 300)/DP) ;
                           // cso2.setLayoutParams(params2);
                        }
                        else if(szam >1200 && szam <1501){
                            cso2.setHeight(rand.nextInt(300)/DP);
                           // cso2.setLayoutParams(params2);
                        }

                     */





                        if (szam >0 && szam <height/6 + 1){
                            params2.height = (int) (rand.nextInt((int) (height/1.25 - height/1.5)) + height/1.5);
                            cso2.setLayoutParams(params2);
                        }
                        else if(szam >height/6 && szam <height/5 + 1){

                            params2.height = rand.nextInt((int) (height/1.5 - height/2)) + height/2;
                            cso2.setLayoutParams(params2);
                        }
                        else if(szam >height/5 && szam <height/4 + 1){
                            params2.height = rand.nextInt(height/2-height/3) + height/3;
                            cso2.setLayoutParams(params2);
                        }
                        else if(szam >height/4 && szam <height/3 + 1){
                            params2.height = rand.nextInt(height/3-height/4) + height/4;
                            cso2.setLayoutParams(params2);
                        }
                        else if(szam > height/3 && szam <height/2 + 1){
                            params2.height = rand.nextInt(height/4);
                            cso2.setLayoutParams(params2);
                        }
                       else {

                            params2.height = 0;
                            cso2.setLayoutParams(params2);

                        }





                      /*  if (szam >0 && szam <height/5 + 1){
                            params2.height = rand.nextInt(height - height/2) + height/2;
                            cso2.setLayoutParams(params2);
                        }
                        else if(szam >height/5 && szam <height/4 + 1){

                            params2.height = rand.nextInt(height/2 - height/3) + height/3;
                            cso2.setLayoutParams(params2);
                        }
                        else if(szam >height/4 && szam <height/3 + 1){
                            params2.height = rand.nextInt(height/3-height/4) + height/4;
                            cso2.setLayoutParams(params2);
                        }
                        else if(szam >height/3 && szam <height/2 + 1){
                            params2.height = rand.nextInt(height/4-height/5) + height/5;
                            cso2.setLayoutParams(params2);
                        }
                        else if(szam > height/2 && szam <height + 1){
                            params2.height = rand.nextInt(height/5);
                            cso2.setLayoutParams(params2);
                        }

                       */






                        /*if (szam >0 && szam <151){

                            params2.height = rand.nextInt(750 - 600) + 600;
                            cso2.setLayoutParams(params2);
                        }
                        else if(szam >150 && szam <301){

                            params2.height = rand.nextInt(600 - 150) + 450;
                            cso2.setLayoutParams(params2);
                        }
                        else if(szam >300 && szam <451){
                            params2.height = rand.nextInt(450-300) + 300;
                            cso2.setLayoutParams(params2);
                        }
                        else if(szam >450 && szam <601){
                            params2.height = rand.nextInt(300-150) + 150;
                            cso2.setLayoutParams(params2);
                        }
                        else if(szam >600 && szam <751){
                            params2.height = rand.nextInt(150);
                            cso2.setLayoutParams(params2);
                        }

                         */

                                          szoj = true;
                }
                else {
                    params2.height = szam ;
                    cso2.setLayoutParams(params2);

                    //  cso2.setHeight(szam/DP);

                      /*  if (szam >0 && szam <301){

                            cso.setHeight( rand.nextInt((1500 - 1200) + 1200)/DP);
                           // cso.setLayoutParams(params);
                        }
                        else if(szam >300 && szam <601){

                            cso.setHeight(rand.nextInt((1200 - 900) + 900)/DP) ;
                           // cso.setLayoutParams(params);
                        }
                        else if(szam >600 && szam <901){
                            cso.setHeight( rand.nextInt((900-600) + 600)/DP);
                           // cso.setLayoutParams(params);
                        }
                        else if(szam >900 && szam <1201){
                            cso.setHeight( rand.nextInt((600-300) + 300)/DP);
                           // cso.setLayoutParams(params);
                        }
                       else if(szam >1200 && szam <1501){
                            cso.setHeight(  rand.nextInt(300)/DP);
                           // cso.setLayoutParams(params);
                        }

                       */


                      /*  if (szam >0 && szam <height/5 + 1){

                            params.height = rand.nextInt(height - height/2) + height/2;
                            cso.setLayoutParams(params);
                        }
                        else if(szam >height/5 && szam <height/4 + 1){

                            params.height = rand.nextInt(height/2 - height/3) + height/3;
                            cso.setLayoutParams(params);
                        }
                        else if(szam >height/4 && szam <height/3 + 1 ){
                            params.height = rand.nextInt(height/3- height/4) + height/4;
                            cso.setLayoutParams(params);
                        }
                        else if(szam >height/3 && szam <height/2 + 1){
                            params.height = rand.nextInt(height/4-height/5) + height/5;
                            cso.setLayoutParams(params);
                        }
                        else if(szam >height/2 && szam <height + 1){
                            params.height = rand.nextInt(height);
                            cso.setLayoutParams(params);
                        }

                       */

                    if (szam >0 && szam <height/6 + 1){

                        params.height = (int) (rand.nextInt((int) (height/1.25 - height/1.5)) + height/1.5);
                        cso.setLayoutParams(params);
                    }
                    else if(szam >height/6 && szam <height/5 + 1){

                        params.height = rand.nextInt((int) (height/1.5 - height/2)) + height/2;
                        cso.setLayoutParams(params);
                    }
                    else if(szam >height/5 && szam <height/4 + 1 ){
                        params.height = rand.nextInt(height/2- height/3) + height/3;
                        cso.setLayoutParams(params);
                    }
                    else if(szam >height/4 && szam <height/3 + 1){
                        params.height = rand.nextInt(height/3-height/4) + height/4;
                        cso.setLayoutParams(params);
                    }
                    else if(szam >height/3 && szam <height/2 + 1){
                        params.height = rand.nextInt(height/4);
                        cso.setLayoutParams(params);
                    }
                   else {

                        params.height = 0;
                        cso.setLayoutParams(params);

                    }




                        /*if (szam >0 && szam <height/6 + 1){

                            params.height = rand.nextInt(height/2 - height/3) + height/3;
                            cso.setLayoutParams(params);
                        }
                        else if(szam >height/6 && szam <height/5 + 1){

                            params.height = rand.nextInt(height/3 - height/4) + height/4;
                            cso.setLayoutParams(params);
                        }
                        else if(szam >height/5 && szam <height/4 + 1 ){
                            params.height = rand.nextInt(height/4- height/5) + height/5;
                            cso.setLayoutParams(params);
                        }
                        else if(szam >height/4 && szam <height/3 + 1){
                            params.height = rand.nextInt(height/5-height/6) + height/6;
                            cso.setLayoutParams(params);
                        }
                        else if(szam >height/3 && szam <height/2 + 1){
                            params.height = rand.nextInt(height/6);
                            cso.setLayoutParams(params);
                        }

                         */



                      /*  if (szam >0 && szam <201){

                            params.height = rand.nextInt((1000 - 800) + 800)/DP;
                            cso.setLayoutParams(params);
                        }
                        else if(szam >200 && szam <401){

                            params.height = rand.nextInt((800 - 600) + 600)/DP;
                            cso.setLayoutParams(params);
                        }
                        else if(szam >400 && szam <601){
                            params.height = rand.nextInt((600-400) + 400)/DP;
                            cso.setLayoutParams(params);
                        }
                        else if(szam >600 && szam <801){
                            params.height = rand.nextInt((400-200) + 200)/DP;
                            cso.setLayoutParams(params);
                        }
                        else if(szam >800 && szam <1001){
                            params.height = rand.nextInt(200)/DP;
                            cso.setLayoutParams(params);
                        }

                       */

                       /* if (szam >0 && szam <151){

                            params.height = rand.nextInt(750 - 600) + 600;
                            cso.setLayoutParams(params);
                        }
                        else if(szam >150 && szam <301){

                            params.height = rand.nextInt(600 - 450) + 450;
                            cso.setLayoutParams(params);
                        }
                        else if(szam >300 && szam <451){
                            params.height = rand.nextInt(450-300) + 300;
                            cso.setLayoutParams(params);
                        }
                        else if(szam >450 && szam <601){
                            params.height = rand.nextInt(300-150) + 150;
                            cso.setLayoutParams(params);
                        }
                        else if(szam >600 && szam <751){
                            params.height = rand.nextInt(150);
                            cso.setLayoutParams(params);
                        }

                        */
                    szoj = false;
                }

                  //  csopoziciok = new int[]{(int) cso.getX(), (int) (cso.getX() + 1), (int) (cso.getX() + 2), (int) (cso.getX() + 3), (int) (cso.getX() + 4),(int) (cso.getX() + 5),(int) (cso.getX() + 6),(int) (cso.getX() + 7),(int) (cso.getX() + 8)};



                   // cso2.setY(cso2.getY()-rand.nextInt(50));

                    cso.setX(1200);
                    cso2.setX(1200);

                }

                if( madarkaxvegzet == cso2xvegzet){
                    counter++;
                    szamlalo.setText(String.valueOf(counter));

                }




                madarka.setY(madarka.getY()+5);

            }



            @Override
            public void onFinish() {
                start();



            }
        }.start();
    }

    public void openDialog(){

        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getChildFragmentManager(),"example dialog");
        exampleDialog.setCancelable(false);

    }

    @Override
    public void applyTexts(boolean plsMenj) {

        plsMenj2 = plsMenj;

    }


    @SuppressLint("SetTextI18n")
    public void ezVanHaVeszetttel(){

        vesztettel.setVisibility(View.VISIBLE);
        szkore.setText(getText(R.string.points ) + ": " + (szamlalo.getText()));

        vesztettel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hatter.setClickable(false);
            }
        });

        madarka.setVisibility(View.GONE);
        cso.setVisibility(View.GONE);
        cso2.setVisibility(View.GONE);
    }

    private void addThought(String nev,int pontok){

        //jellemzes = review.getText().toString().trim();

        Map<String,Object> data = new HashMap<>();
        data.put("nev",nev);
        data.put("pontok",pontok);

        collectionReference.add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {

                Toast.makeText(getContext(), "megment", Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public void onPause() {
        super.onPause();
        ido.cancel();

    }
    }
