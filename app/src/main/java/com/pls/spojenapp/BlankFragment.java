package com.pls.spojenapp;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
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

    TextView MilyenNap,csoport,inniv,uzsonnaa,teszt;
    Calendar cal = Calendar.getInstance();
    int nap,pozi,ifbeMegEgyFeltetelMertRosszulMegyASpinnerHaEztKiveszedMeglatodMireGondolok = 2;
    Spinner napok;
    Obed obed,inniva,uzsi;
    ConstraintLayout mConstraintLayoutGallery;
    AnimationDrawable mAnimationDrawableGallery;
    Button valtoztato;
    Boolean csoportAllapot = false,masikCsicskaboolean;
    ConstraintLayout kaja;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference journaRef,inni,uzsonna;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_blank, container, false);


        /*public View onCreateView(@NonNull LayoutInflater inflater,
                ViewGroup container, Bundle savedInstanceState) {


            galleryViewModel =
                    ViewModelProviders.of(this).get(GalleryViewModel.class);
            View root = inflater.inflate(R.layout.fragment_gallery, container, false);*/


        MilyenNap = root.findViewById(R.id.textView8);
        napok = root.findViewById(R.id.spinner3);
        mConstraintLayoutGallery = root.findViewById(R.id.ebed);
        valtoztato = root.findViewById(R.id.button192);
        csoport = root.findViewById(R.id.textView5);
        kaja = root.findViewById(R.id.kaja);
        inniv = root.findViewById(R.id.textView10);
        uzsonnaa = root.findViewById(R.id.textView66);



        nap = cal.get(Calendar.DAY_OF_WEEK);

        String napBetuben = String.valueOf(nap);


        mAnimationDrawableGallery = (AnimationDrawable) mConstraintLayoutGallery.getBackground();

        mAnimationDrawableGallery.setEnterFadeDuration(2000);
        mAnimationDrawableGallery.setExitFadeDuration(4000);
        mAnimationDrawableGallery.start();

       // csoportAllapot = false;


        kaja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "ez megy more xddd", Toast.LENGTH_SHORT).show();
            }
        });

        journaRef = db.collection("ebedA").document("kaja");
        inni = db.collection("ebedA").document("inni");
        uzsonna = db.collection("ebedA").document("uzsonna");
        adatbeolvasoCucc(journaRef,MilyenNap,obed);
        adatbeolvasoCucc(inni,inniv,inniva);
        adatbeolvasoCucc(uzsonna,uzsonnaa,uzsi);



        valtoztato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!csoportAllapot){
                    csoportAllapot = true;
                    csoport.setText("B");
                    valtoztato.setText("A");
                    if(pozi!= 0) {
                        nap = pozi + 1;
                    }
                    journaRef = db.collection("ebedB").document("kaja");
                    inni = db.collection("ebedB").document("inni");
                    uzsonna = db.collection("ebedB").document("uzsonna");


                }
                else {
                    csoportAllapot = false;
                    csoport.setText("A");
                    valtoztato.setText("B");
                    if(pozi!= 0) {
                        nap = pozi + 1;
                    }
                    journaRef = db.collection("ebedA").document("kaja");
                    inni = db.collection("ebedA").document("inni");
                    uzsonna = db.collection("ebedA").document("uzsonna");


                }
                adatbeolvasoCucc(journaRef,MilyenNap,obed);
                adatbeolvasoCucc(inni,inniv,inniva);
                adatbeolvasoCucc(uzsonna,uzsonnaa,uzsi);



            }
        });






        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.dni, android.R.layout.simple_spinner_item);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        napok.setAdapter(adapter);


        napok.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                boolean kutyaButaUtallomAzEgeszet = csoportAllapot;


                pozi = position;


                journaRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        obed = documentSnapshot.toObject(Obed.class);
                    }
                });
                inni.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        inniva = documentSnapshot.toObject(Obed.class);
                    }
                });
                uzsonna.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        uzsi = documentSnapshot.toObject(Obed.class);
                    }
                });



                switch (position){
                    case 1: MilyenNap.setText(obed.getHet());inniv.setText(inniva.getHet());uzsonnaa.setText(uzsi.getHet());break;
                    case 2: MilyenNap.setText(obed.getKedd());inniv.setText(inniva.getKedd());uzsonnaa.setText(uzsi.getKedd());break;
                    case 3: MilyenNap.setText(obed.getSzer()); inniv.setText(inniva.getSzer());uzsonnaa.setText(uzsi.getSzer());break;
                    case 4: MilyenNap.setText(obed.getCsut()); inniv.setText(inniva.getCsut()); uzsonnaa.setText(uzsi.getCsut());break;
                    case 5: MilyenNap.setText(obed.getPen());inniv.setText(inniva.getPen());uzsonnaa.setText(uzsi.getPen());break;
                    
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return  root;
        }

        public void adatbeolvasoCucc(DocumentReference pelda, final TextView kiiras, final Obed kja){




            pelda.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {

                    Obed masikkaja = kja;

                    masikkaja = documentSnapshot.toObject(Obed.class);


               /* if(documentSnapshot.exists()){

                    Toast.makeText(getContext(), "megy", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getContext(), "nincs data", Toast.LENGTH_SHORT).show();
                }

                */

                    switch (nap){
                        case 2: kiiras.setText(masikkaja.getHet());break;
                        case 3: kiiras.setText(masikkaja.getKedd());break;
                        case 4: kiiras.setText(masikkaja.getSzer());break;
                        case 5: kiiras.setText(masikkaja.getCsut());break;
                        case 6: kiiras.setText(masikkaja.getPen());break;

                    }

                }
            });
           /* .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(getContext(),"nem megy valami",Toast.LENGTH_SHORT).show();

                    Log.d("hiba", e.toString());

                }
            });

            */


        }


}
