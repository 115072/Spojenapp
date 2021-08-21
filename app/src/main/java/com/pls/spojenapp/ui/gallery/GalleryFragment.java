package com.pls.spojenapp.ui.gallery;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.pls.spojenapp.DruhePoschodie;
import com.pls.spojenapp.HodinyDoTabuly;
import com.pls.spojenapp.Prizemie;
import com.pls.spojenapp.Prve_poschodie;
import com.pls.spojenapp.R;
import com.pls.spojenapp.Sestka_a;
import com.pls.spojenapp.Sestka_b;
import com.pls.spojenapp.Sestka_c;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.common.collect.ObjectArrays;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Arrays;
import java.util.Date;

public class GalleryFragment<elsoosztaly> extends Fragment {


    private GalleryViewModel galleryViewModel;

  int szam ;
  String idok;
  int idoSzamban;
  Spinner spinner;
  int idokSzamban;
    String text;
    int szinSzoveg;
    String s;
    String spinnerText;
    View roote;
    Spinner csoport;
    Spinner hodiny;
    String h1,h2,h3,h4,h5,h6,h7,h8,h0;
    String IntentAtvitel;
    int pozicia;
    String trieda;
    ConstraintLayout mConstraintLayoutGallery;
    AnimationDrawable mAnimationDrawableGallery;
    Spinner triySkupiny;
    int attettSzam, attettSzam2;
    TextView H0,H1,H2,H3,H4,H5,H6,H7,H8;
    TextView H0h,H1h,H2h,H3h,H4h,H5h,H6h,H7h,H8h;
    String skupinaDoReference, skupinaDoReference2;
    HodinyDoTabuly priklad;
    String nieJeHodina = "nemas hodinu";
    String nejakyProblem = "Nejaky problem sa stal v zapisani aleb inde";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();


     DocumentReference A,B,S2;

    final String[] prizemieUcebne = {"D001","C001","C002","C008","C009","C010","C011","F004","B001","A001","A002","A008","A009","A010","A011","B006"};
    final String[] prvePoschodie = {"D108","D107","D106","D1051S1","D1051S2","D102","D101","C101","C102","C1031S3","C1032S4","C106","C107","C108","C109","F103","B110","B109","B108","B107","B106","B102","B101","A101","A102","A106","A107","A108","A109"};
    final String[] druhePoschodie = {"F205","F201","F206","F204","F203"};
    final String[] sestkaA = {"SA103","SA104","SA01","SA05"};
    final String[] sestkaB = {"SB08","SB05","SB106","SB107"};
    final String[] sestkaC = {"SC108","SC104","SC01","SC02"};



    String [] joined1 = ObjectArrays.concat(prizemieUcebne,prvePoschodie,String.class);
    String [] joined2 = ObjectArrays.concat(druhePoschodie,sestkaA,String.class);
    String [] joined3 = ObjectArrays.concat(sestkaB,sestkaC,String.class);
    String [] joined4 = ObjectArrays.concat(joined1,joined2,String.class);
    String [] joined5 = ObjectArrays.concat(joined3,joined4,String.class);


    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
         roote = inflater.inflate(R.layout.fragment_gallery, container, false);

        spinner = roote.findViewById(R.id.spinner);
        csoport = roote.findViewById(R.id.spinner2);
        hodiny = roote.findViewById(R.id.spinner4);
        mConstraintLayoutGallery = roote.findViewById(R.id.gallery);
        triySkupiny = roote.findViewById(R.id.spinnerTriTriedy);
        H0 = roote.findViewById(R.id.textView29);
        H1 = roote.findViewById(R.id.textView30);
        H2 = roote.findViewById(R.id.textView31);
        H3 = roote.findViewById(R.id.textView32);
        H4 = roote.findViewById(R.id.textView33);
        H5 = roote.findViewById(R.id.textView34);
        H6 = roote.findViewById(R.id.textView35);
        H7 = roote.findViewById(R.id.textView36);
        H8 = roote.findViewById(R.id.textView37);
        H0h = roote.findViewById(R.id.textView7);
        H1h = roote.findViewById(R.id.textView9);
        H2h = roote.findViewById(R.id.textView12);
        H3h = roote.findViewById(R.id.textView13);
        H4h = roote.findViewById(R.id.textView14);
        H5h = roote.findViewById(R.id.textView15);
        H6h = roote.findViewById(R.id.textView16);
        H7h = roote.findViewById(R.id.textView17);
        H8h = roote.findViewById(R.id.textView27);


        mAnimationDrawableGallery = (AnimationDrawable) mConstraintLayoutGallery.getBackground();

        mAnimationDrawableGallery.setEnterFadeDuration(2000);
        mAnimationDrawableGallery.setExitFadeDuration(4000);
        mAnimationDrawableGallery.start();


        csoport.setPrompt("valassz csoportot cigo");



        cas();


        final String hodinyArray [] = {h0,h1,h2,h3,h4,h5,h6,h7,h8};

        final String triSkupinoveTriedy [] = {"IV.DA","III.DA","II.DA","I.DA"};


        // innet lefele  7. sorig innet szamitva az elso spinner  helyrehozasa/egybekotese a szoveggel
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.planets_array, R.layout.white_text);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


        //innet lefele  7. sorig innet szamitva a masodik spinner helyrehozasa/egybekotese a szoveggel
         final ArrayAdapter<CharSequence> skupina = ArrayAdapter.createFromResource(getContext(),
                R.array.skupina, R.layout.white_text);


        skupina.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        csoport.setAdapter(skupina);


        //innet lefele  7. sorig innet szamitva harmadik spinner helyrehozasa/egybekotese a szoveggel
        ArrayAdapter<CharSequence> hodin = ArrayAdapter.createFromResource(getContext(),
                R.array.hodiny, R.layout.white_text);


        hodin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        hodiny.setAdapter(hodin);

//inntet lefele 7.sorig innet szamitva a harom csoportos spinner  helyrehozasa/egybekovetes szoveggel
        ArrayAdapter<CharSequence> triskup = ArrayAdapter.createFromResource(getContext(),
                R.array.triSkupina,R.layout.white_text);


        triskup.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        triySkupiny.setAdapter(triskup);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text = parent.getItemAtPosition(position).toString();

                final int csicskavok = position;


                szam = position;
                trieda = spinner.getSelectedItem().toString();

                A = db.collection(trieda)
                        .document("A");

                B = db.collection(trieda)
                        .document("B");

                S2 = db.collection(trieda)
                        .document("S2");


                spinnerText = spinner.getSelectedItem().toString();


                SimpleDateFormat formatter = new SimpleDateFormat("HHmm");
                Date date = new Date();

                idok = formatter.format(date);


                s=String.valueOf(szinSzoveg);


//                if(csicskavok != position){
//                     csoport.setSelection(0);
//                }

                hodiny.setSelection(0);


           //ido.setText(String.valueOf(skuPina));


                idoSzamban= Integer.parseInt(idok);

             //   for (int i=0;i<triSkupinoveTriedy.length;i++) {
                    if (trieda.equals("IV.DA") || trieda.equals("III.DA") ||  trieda.equals("II.DA")  || trieda.equals("I.DA") ){

                        triySkupiny.setVisibility(View.VISIBLE);
                        csoport.setVisibility(View.GONE);
                      //  H0.setText(trieda + skupina3);
                        csoport.setSelection(0);
                    }
                    else{
                        csoport.setVisibility(View.VISIBLE);
                        triySkupiny.setVisibility(View.GONE);
                       // H0.setText(trieda + skupina2);
                        triySkupiny.setSelection(0);



                    }


             //   }





            /*    if(text.equals("III.DI") && idoSzamban == 2343) {
                    //egy.setBackgroundResource(R.drawable.my_border);
                    gomb1.setBackgroundColor(Color.parseColor("#000000"));
                    szinSzoveg = ((ColorDrawable) gomb1.getBackground()).getColor();

                    for (int i = 1; i<3; i++){
                        buttonArray[i].setBackgroundResource(R.drawable.my_border);
                    }








                }
                else if(text.equals("II.DI") /*&& idoSzamban == 2343){
                    for (int i = 0; i<3; i++){
                        buttonArray[i].setBackgroundResource(R.drawable.my_border);
                        if (i == 1){
                            gomb2.setBackgroundColor(Color.BLUE);
                            szinSzoveg = ((ColorDrawable) gomb2.getBackground()).getColor();
                        }
                    }


                }
                else if(text.equals("I.DI") /*&& idoSzamban == 2343){
                    gomb3.setBackgroundColor(Color.YELLOW);
                    openSpojenappTest();
                    szinSzoveg = ((ColorDrawable) gomb3.getBackground()).getColor();
                    for (int i = 0; i<2; i++){
                        buttonArray[i].setBackgroundResource(R.drawable.my_border);
                    }


                }

                */

               // rozvrhUpdate();




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        csoport.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                if(position != 0) {


                    hodiny.setVisibility(View.VISIBLE);
                }
                else { hodiny.setVisibility(View.GONE);}


                attettSzam2=position;

                 skupinaDoReference = trieda + csoport.getSelectedItem().toString();
//                if(!skupinaDoReference.equals("")){
//                    triySkupiny.setSelection(0);
//                }

                if(position != 0) {
                    rozvrhUpdate();
                }




                //H1.setText(skupinaDoReference);



                hodiny.setSelection(0);





                 cas();





              //  skuPina = position;


              //  ido.setText(String.valueOf(attettSzam2));


               saveData();


              //  rozvrhUpdate();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        triySkupiny.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (trieda.equals("IV.DA") || trieda.equals("III.DA") ||  trieda.equals("II.DA")  || trieda.equals("I.DA") ) {

                    if (position != 0) {
                        hodiny.setVisibility(View.VISIBLE);
                    } else {
                        hodiny.setVisibility(View.GONE);
                    }

                }

                attettSzam = position;

                skupinaDoReference2 = trieda + triySkupiny.getSelectedItem().toString();

//                if(!skupinaDoReference2.equals("")){
//                    csoport.setSelection(0);
//                }
               // rozvrhUpdate();


              //  H0.setText(skupinaDoReference2);


                hodiny.setSelection(0);

                if(position != 0){
                    rozvrhUpdate();
                }


                //  rozvrhUpdate();


               // skuPina = position;

               // proba.setText(String.valueOf(skuPina));

                cas();


                saveData();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        /*  if(!h0.equals("-")) {

                                }
                                    else if (h0.equals("-")){
                                        Toast.makeText(getContext(), nieJeHodina, Toast.LENGTH_SHORT).show();
                                    }

                                else {Toast.makeText(getContext(), nejakyProblem, Toast.LENGTH_SHORT).show();}

                                    if(h0.equals("-")){

                                    }
                                    else{
                                        Toast.makeText(getContext(), nejakyProblem, Toast.LENGTH_SHORT).show();
                                    }

                                    */





        hodiny.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,  int position, long id) {

                pozicia = position;


                if(attettSzam2 == 1  || attettSzam ==1){

                    A.addSnapshotListener((Activity) requireContext(), new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

                            assert value != null;

                            switch (pozicia){

                                case 0: break;
                                case 1:  h0 = value.getString("0");
                                         suplovanie(h0);
                                 //   hodiny.setSelection(0);
                                         break;
                                case 2:  h1 = value.getString("1");
                                         suplovanie(h1);
                                  //  hodiny.setSelection(0);
                                         break;
                                case 3:  h2 = value.getString("2");
                                         suplovanie(h2);
                                   // hodiny.setSelection(0);
                                         break;
                                case 4:  h3 = value.getString("3");
                                         suplovanie(h3);
                                         break;
                                case 5:  h4 = value.getString("4");
                                         suplovanie(h4);
                                         break;
                                case 6:  h5 = value.getString("5");
                                         suplovanie(h5);
                                         break;
                                case 7:  h6 = value.getString("6");
                                         suplovanie(h6);
                                         break;
                                case 8:  h7 = value.getString("7");
                                         suplovanie(h7);
                                         break;
                                case 9:  h8 = value.getString("8");
                                         suplovanie(h8);
                                         break;
                            }
                        }
                    });

                }

                else if(attettSzam2 == 2 || attettSzam == 2){

                    B.addSnapshotListener((Activity) requireContext(), new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

                            assert value != null;

                            switch (pozicia){

                                case 0: break;
                                case 1:  h0 = value.getString("0");
                                    suplovanie(h0);
                                    break;
                                case 2:  h1 = value.getString("1");
                                    suplovanie(h1);
                                    break;
                                case 3:  h2 = value.getString("2");
                                    suplovanie(h2);
                                    break;
                                case 4:  h3 = value.getString("3");
                                    suplovanie(h3);
                                    break;
                                case 5:  h4 = value.getString("4");
                                    suplovanie(h4);
                                    break;
                                case 6:  h5 = value.getString("5");
                                    suplovanie(h5);
                                    break;
                                case 7:  h6 = value.getString("6");
                                    suplovanie(h6);
                                    break;
                                case 8:  h7 = value.getString("7");
                                    suplovanie(h7);
                                    break;
                                case 9:  h8 = value.getString("8");
                                    suplovanie(h8);
                                    break;
                            }

                        }
                    });

                }



                else if(attettSzam == 3){

                    S2.addSnapshotListener((Activity) requireContext(), new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

                            assert value != null;

                            switch (pozicia){

                                case 0: break;
                                case 1:  h0 = value.getString("0");
                                    suplovanie(h0);
                                    break;
                                case 2:  h1 = value.getString("1");
                                    suplovanie(h1);
                                    break;
                                case 3:  h2 = value.getString("2");
                                    suplovanie(h2);
                                    break;
                                case 4:  h3 = value.getString("3");
                                    suplovanie(h3);
                                    break;
                                case 5:  h4 = value.getString("4");
                                    suplovanie(h4);
                                    break;
                                case 6:  h5 = value.getString("5");
                                    suplovanie(h5);
                                    break;
                                case 7:  h6 = value.getString("6");
                                    suplovanie(h6);
                                    break;
                                case 8:  h7 = value.getString("7");
                                    suplovanie(h7);
                                    break;
                                case 9:  h8 = value.getString("8");
                                    suplovanie(h8);
                                    break;
                            }

                        }
                    });


                }

                saveData();
             //   hodiny.setSelection(0);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    /*    ArrayAdapter<CharSequence> skupina = ArrayAdapter.createFromResource(getContext(),
                R.array.skupina, android.R.layout.simple_spinner_item);


        skupina.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        csoport.setAdapter(skupina);


        csoport.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                hodiny.setVisibility(View.VISIBLE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

     */



    //  idoMegadas.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View v) {

            /*  SimpleDateFormat formatter = new SimpleDateFormat("HHmm");
              Date date = new Date();

              idok = formatter.format(date);


               s=String.valueOf(szinSzoveg);



              ido.setText(idok);

              idoSzamban= Integer.parseInt(idok);*/

            //  tunj.setVisibility(View.GONE);


              //gomb4.setBackgroundColor(Color.YELLOW);




   //       }
   //   });*/

//         ora.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*
//
//
//
//
//
//
//
//
//           if(text.equals("III.DI")) {
//                //egy.setBackgroundResource(R.drawable.my_border);
//                gomb1.setBackgroundColor(Color.RED);
//                for (int i = 1; i<3; i++){
//                    buttonArray[i].setBackgroundResource(R.drawable.my_border);
//                }
//
//
//            }
//            else if(text.equals("II.DI") ){
//                for (int i = 0; i<3; i++){
//                    buttonArray[i].setBackgroundResource(R.drawable.my_border);
//                    if (i == 1){
//                        gomb2.setBackgroundColor(Color.BLUE);
//                    }
//                }
//
//
//                }
//                else if(text.equals("I.DI") ){
//                    gomb3.setBackgroundColor(Color.YELLOW);
//                for (int i = 0; i<2; i++){
//                    buttonArray[i].setBackgroundResource(R.drawable.my_border);
//                }
//
//
//                }
//            else{
//                gomb1.setBackgroundColor(Color.MAGENTA);
//
//
//            }
//
//              //  tunj.setVisibility(View.VISIBLE);
//
//
//
//
//     */
//
//               /* if(szinSzoveg == -16777216){
//
//                    openSpojenappTest();
//                }*/
//
//
//
//
//
//            }
//        });




loadData();
updateViews();
        return roote;
    }



    public static final String EXTRA_NUMBER = "idoSzamban";
    public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";

    public void openPrizemie(){

        Intent intent = new Intent( getContext(), Prizemie.class);

       intent.putExtra("hodina",IntentAtvitel);

       hodiny.setSelection(0);

        startActivity(intent);

    }

    public void open1Poschodie(){

        Intent intent = new Intent( getContext(), Prve_poschodie.class);

        intent.putExtra("hodina",IntentAtvitel);

        hodiny.setSelection(0);

        startActivity(intent);

    }

    public void open2Poschidie(){

        Intent intent = new Intent( getContext(), DruhePoschodie.class);

        intent.putExtra("hodina",IntentAtvitel);

        hodiny.setSelection(0);

        startActivity(intent);

    }

    public void open6A(){

        Intent intent = new Intent( getContext(), Sestka_a.class);

        intent.putExtra("hodina",IntentAtvitel);

        hodiny.setSelection(0);

        startActivity(intent);

    }

    public void open6B(){

        Intent intent = new Intent( getContext(), Sestka_b.class);

        intent.putExtra("hodina",IntentAtvitel);

        hodiny.setSelection(0);

        startActivity(intent);

    }


    public void open6C(){

        Intent intent = new Intent( getContext(), Sestka_c.class);

        intent.putExtra("hodina",IntentAtvitel);

        hodiny.setSelection(0);

        startActivity(intent);

    }
    public void saveData() {

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("valami", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putInt("spinner",szam);
        editor.putInt("skupina",attettSzam2);
        editor.putInt("3skup",attettSzam);


        editor.apply();
    }

    public void loadData() {

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("valami", Context.MODE_PRIVATE);

        szam = sharedPreferences.getInt("spinner",0);
        attettSzam2 = sharedPreferences.getInt("skupina",0);
        attettSzam = sharedPreferences.getInt("3skup",0);

    }

    public void updateViews() {



        spinner.setSelection(szam);
        csoport.setSelection(attettSzam2);
       triySkupiny.setSelection(attettSzam);




    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void cas(){
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("HHmm");
        Date date = new Date();

        idok = formatter.format(date);

        idokSzamban = Integer.parseInt(idok);




        if (idokSzamban >= 705 && idokSzamban <= 750){

            rozvrhSzinezes(2);

        }
        else if (idokSzamban >= 755 && idokSzamban <= 840) {

            rozvrhSzinezes(3);

        }
        else if (idokSzamban >= 850 && idokSzamban <= 935){
            rozvrhSzinezes(5);
        }
        else if (idokSzamban >= 945 && idokSzamban <= 1030){
            rozvrhSzinezes(7);
        }
        else if (idokSzamban >= 1040 && idokSzamban <= 1125){
            rozvrhSzinezes(11);

        }
        else if (idokSzamban >= 1130 && idokSzamban <= 1215){
            rozvrhSzinezes(13);

        }
        else if (idokSzamban >= 1245 && idokSzamban <= 1330){
            rozvrhSzinezes(17);
        }
        else if (idokSzamban >= 1335 && idokSzamban <= 1420){
            rozvrhSzinezes(19);
        }
        else if (idokSzamban >= 1425 && idokSzamban <= 1510){
            rozvrhSzinezes(23);
        }
        else{ }

    }

    public void rozvrhUpdate(){







        DocumentReference tabula;


        if (trieda.equals("IV.DI") || trieda.equals("III.DI") || trieda.equals("II.DI") || trieda.equals("I.DI") ){
           tabula = db.collection(trieda).document(skupinaDoReference);
        }
        else{
           tabula =  db.collection(trieda).document(skupinaDoReference2);
        }




        tabula.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                priklad = documentSnapshot.toObject(HodinyDoTabuly.class);

                H0.setText(priklad.getNulta());
                H1.setText(priklad.getPrva());
                H2.setText((priklad.getDruha()));
                H3.setText(priklad.getTretia());
                H4.setText(priklad.getStvrta());
                H5.setText(priklad.getPiata());
                H6.setText(priklad.getSiesta());
                H7.setText(priklad.getSiedma());
                H8.setText(priklad.getOsma());

            }
        });

      /*  final TextView[] tabule = {H0,H1,H2,H3,H4,H5,H6,H7,H8};
        final TextView[] hodinyVtabuly = {H0h,H1h,H2h,H3h,H4h,H5h,H6h,H7h,H8h};
         String [] tabulecontent = {H0.getText().toString(),H1.getText().toString(),H2.getText().toString(),H3.getText().toString(),H4.getText().toString(),H5.getText().toString(),H6.getText().toString(),H7.getText().toString(),H8.getText().toString()};

         proba.setText(Arrays.toString(tabulecontent));

        for(int i=0;i<tabule.length;i++){
            if(tabulecontent[i].equals("-")){
                tabule[i].setVisibility(View.GONE);
                hodinyVtabuly[i].setVisibility(View.GONE);
            }
            else{
                tabule[i].setVisibility(View.VISIBLE);
                hodinyVtabuly[i].setVisibility(View.VISIBLE);

            }


        }

       */

    }


    public void suplovanie (String priklad){

        if(!Arrays.asList(joined5).contains(priklad) && !priklad.equals("-")){
            Toast.makeText(getContext(), R.string.valamiHibaLehet, Toast.LENGTH_SHORT).show();
        }

        if(priklad.equals("-")){
            Toast.makeText(getContext(), R.string.nincsorad, Toast.LENGTH_SHORT).show();
        }

        if (Arrays.asList(prizemieUcebne).contains(priklad)) {
                IntentAtvitel = String.valueOf(priklad);
                openPrizemie();
            }
        else if (Arrays.asList(prvePoschodie).contains(priklad)) {
            IntentAtvitel = String.valueOf(priklad);
            open1Poschodie();
        }
        else if (Arrays.asList(druhePoschodie).contains(priklad)) {
            IntentAtvitel = String.valueOf(priklad);
            open2Poschidie();
        }
        else if (Arrays.asList(sestkaA).contains(priklad)) {
            IntentAtvitel = String.valueOf(priklad);
            open6A();
        }
        else if (Arrays.asList(sestkaB).contains(priklad)) {
            IntentAtvitel = String.valueOf(priklad);
            open6B();
        }
        else if (Arrays.asList(sestkaC).contains(priklad)) {
            IntentAtvitel = String.valueOf(priklad);
            open6C();
        }

    }


    public void rozvrhSzinezes( int prim){

        final TextView[] tabule = {H0,H1,H2,H3,H4,H5,H6,H7,H8};
        final TextView[] hodinyVtabuly = {H0h,H1h,H2h,H3h,H4h,H5h,H6h,H7h,H8h};
        int[] pomocka =  {2,3,5,7,11,13,17,19,23};


        for (int i=0;i<tabule.length;i++){
            if(pomocka[i] % prim == 0){
                tabule[i].setBackgroundColor(Color.parseColor("#e6dfa1"));
                hodinyVtabuly[i].setBackgroundColor(Color.parseColor("#e6dfa1"));
                tabule[i].setTextColor(Color.BLACK);
                hodinyVtabuly[i].setTextColor(Color.BLACK);
            }
            else{
                tabule[i].setBackgroundResource(R.drawable.rozvrh_oldal);
                hodinyVtabuly[i].setBackgroundResource(R.drawable.rozvrh_oldal);
                tabule[i].setTextColor(Color.WHITE);
                hodinyVtabuly[i].setTextColor(Color.WHITE);
            }
        }

    }

    }








