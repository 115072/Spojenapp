package com.pls.spojenapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;



public class Tanarok extends AppCompatActivity {

    TextView nev, bemutatkozo;
    Button sendReview;
    EditText review;
    TextView kontakt;
    String name;
    String trieda1;
    String trieda2;
    Button Trieda1, Trieda2;
    String priezvisko;
    ConstraintLayout mConstraintLayout;
    AnimationDrawable mAnimationDrawable;
    CircleImageView profil;
    String tanar = "1";
    Boolean isCurseword;
    ListView listView;



    final String[] prizemieUcebne = {"D001","C001","C002","C008","C009","C010","C011","F004","B001","A001","A002","A008","A009","A010","A011","B006"};
    final String[] prvePoschodie = {"D108","D107","D106","D1051S1","D1051S2","D102","D101","C101","C102","C1031S3","C1032S4","C106","C107","C108","C109","F103","B110","B109","B108","B107","B106","B102","B101","A101","A102","A106","A107","A108","A109","F107"};
    final String[] druhePoschodie = {"F205","F201","F206","F204","F203"};
    final String[] sestkaA = {"SA103","SA104","SA01","SA05"};
    final String[] sestkaB = {"SB08","SB05","SB106","SB107"};
    final String[] sestkaC = {"SC108","SC104","SC01","SC02"};
    String tiltottSzavak = "hülye,buta,kuki,penisz,vagina,punci";



    String[] szavak =  tiltottSzavak.split(",");


    ArrayList<String> arrayList = new ArrayList<>();



    private ExampleItem itemsModal;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private DocumentReference journaRef = db.collection("tanarok")
            .document(tanar);

    private CollectionReference collectionReference;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanarok);

        nev = findViewById(R.id.textView3);
        bemutatkozo = findViewById(R.id.textView4);
        profil = findViewById(R.id.profile_image);
        sendReview = findViewById(R.id.button13);
        review = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);
        Trieda1 = findViewById(R.id.button9);
        Trieda2 = findViewById(R.id.button7);
        kontakt = findViewById(R.id.textView11);







        mConstraintLayout = findViewById(R.id.ucitelia);

        mAnimationDrawable = (AnimationDrawable) mConstraintLayout.getBackground();

        mAnimationDrawable.setEnterFadeDuration(2000);
        mAnimationDrawable.setExitFadeDuration(4000);
        mAnimationDrawable.start();


        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            itemsModal = (ExampleItem) intent.getSerializableExtra("data");

            name = itemsModal.getText1();
            priezvisko = itemsModal.getText2();

            nev.setText(name + " " + priezvisko);


           // Log.e("PASSED", " ==> " + itemsModal.getText1());
           // Log.e("PASSED", " ==> " + itemsModal.getText2());
        }


        if(name.equals("Antonio") && priezvisko.equals("Montana")){
            bemutatkozo.setText(R.string.AntonioMontana);
            kontakt.setText("TonyMontana@gmail.com");
            trieda1 = "D101";
            trieda2 = "SC01";
            profil.setImageResource(R.drawable.scarfacenew);
            tanar = "AntonioMontana";
        }
        else if(name.equals("Jennifer") && priezvisko.equals("Lopez")){
            bemutatkozo.setText(R.string.JenniferLopez);
            kontakt.setText("JLO@gmail.com");
            trieda1 = "D001";
            trieda2 = "SB08";
            profil.setImageResource(R.drawable.jenniferlopez);
            tanar = "JLO";
        }
        else if(name.equals("Michael") && priezvisko.equals("Jordan")){
            bemutatkozo.setText(R.string.MichaelJordan);
            kontakt.setText("Jordan@gmail.com");
            trieda1 = "C106";
            trieda2 = "C107";
            profil.setImageResource(R.drawable.michaeljordan);
            tanar = "MJordan";

        }







        else if (name.equals("Gabriela") && priezvisko.equals("Alexovič")) {
            bemutatkozo.setText(R.string.GabrielaAlexovičText);
            kontakt.setText("galexovic@spsenz.sk");
            trieda1 = "C008";
            trieda2 = "D101";
          //  tanar = "GabrielaAlexovics";

        }
        else if (name.equals("Katarína") && priezvisko.equals("Antošíková")) {
            trieda1 = "D106";
            trieda2 = "D101";
          //  tanar = "KatarinaAntosikova";


        }
        else if (name.equals("Emőke") && priezvisko.equals("Benková")) {
            bemutatkozo.setText(R.string.EmokeBenkovaText);
            kontakt.setText("Emokebenkova@gmail.com ");
            trieda1 = "C008";
            trieda2 = "C010";
            profil.setImageResource(R.drawable.emokebenkova);
           // tanar = "EmokeBenkova";


        }
        else if (name.equals("Andrea") && priezvisko.equals("Caliskan")) {
            trieda1 = "SA01";
            trieda2 = "D101";

        }
        else if (name.equals("Viktória") && priezvisko.equals("Csepedi")) {
            trieda1 = "SB05";
            trieda2 = "D101";

        }
        else if (name.equals("Bálint") && priezvisko.equals("Csörgő")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Peter") && priezvisko.equals("Cucor")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Ildikó") && priezvisko.equals("Dallosová")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Lenka") && priezvisko.equals("Danácsová")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Imrich") && priezvisko.equals("Dékány")) {
            bemutatkozo.setText(R.string.ImrichDekany);
            kontakt.setText("idekany@spsenz.sk");
            trieda1 = "D102";
            trieda2 = "F107";
          //  tanar = "ImrichDekany";

        }
        else if (name.equals("Jozef") && priezvisko.equals("Elek")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Katarína") && priezvisko.equals("Fabuľová")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Ladislav") && priezvisko.equals("Ferencz")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("László") && priezvisko.equals("Forró")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Karol") && priezvisko.equals("Gelle")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Juliana") && priezvisko.equals("Gyuríková")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Koloman") && priezvisko.equals("Halász")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("František") && priezvisko.equals("Hortai")) {
           bemutatkozo.setText(R.string.FrantisekHortai);
           kontakt.setText("fhortai@spsenz.sk");
            trieda1 = "SA01";
            trieda2 = "C106";
         //   tanar = "FrantisekHortai";
            profil.setImageResource(R.drawable.frantisekhortai);


        }
        else if (name.equals("Peter") && priezvisko.equals("Hudec")) {
            bemutatkozo.setText(R.string.PeterHudec);
            kontakt.setText("spse.hud@gmail.com");
            trieda1 = "SA104";
            trieda2 = "C106";
          //  tanar = "PeterHudec";

        }
        else if (name.equals("Erika") && priezvisko.equals("Jóbová")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Lucia") && priezvisko.equals("Kálaziová")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Márius") && priezvisko.equals("Karadi")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Aneta") && priezvisko.equals("Katonová")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Roman") && priezvisko.equals("Keszeg")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Silvia") && priezvisko.equals("Kollárová")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Ladislav") && priezvisko.equals("Korinek")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Katarína") && priezvisko.equals("Košnarová")) {
            bemutatkozo.setText(R.string.KatarínaKošnarováText);
            kontakt.setText("kkosnarova@spsenz");
            trieda1 = "F204";
            trieda2 = "C008";

        }
        else if (name.equals("Imrich") && priezvisko.equals("Kovács")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Peter") && priezvisko.equals("Lénárt")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Ladislav") && priezvisko.equals("Lencsés")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Michal") && priezvisko.equals("Miko")) {
            bemutatkozo.setText(R.string.MichalMikoText);
            kontakt.setText("michalm68@gmail.com");
            trieda1 = "C109";
            trieda2 = "B102";
            profil.setImageResource(R.drawable.michalmiko);

        }
        else if (name.equals("Melinda") && priezvisko.equals("Mojzešová")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Martin") && priezvisko.equals("Molnár")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Tibor") && priezvisko.equals("Molnár")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Ildikó") && priezvisko.equals("Németh")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Zuzana") && priezvisko.equals("Nováková")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Marian") && priezvisko.equals("Otruba")) {
            bemutatkozo.setText(R.string.MariánOtrubaText);
            kontakt.setText("motruba@spsenz.sk");
            trieda1 = "B102";
            trieda2 = "A108";

        }
        else if (name.equals("Katarína") && priezvisko.equals("Pokorná")) {
            bemutatkozo.setText(R.string.KatarínaPokornáText);
            kontakt.setText("kpokorna@spsenz.sk");
            trieda1 = "F201";
            trieda2 = "F104";

        }
        else if (name.equals("Ivan") && priezvisko.equals("Polák")) {
            bemutatkozo.setText(R.string.IvanPolákText);
            kontakt.setText("polak.ivan@centrum.sk, tel: 0908 758 235,");
            trieda1 = "A108";
            trieda2 = "A108";
            profil.setImageResource(R.drawable.ivanpolak);

        }
        else if (name.equals("Mária") && priezvisko.equals("Poláková")) {
            bemutatkozo.setText(R.string.MáriaPolákováText);
            kontakt.setText("maria.polakoa3@gmail.com");
            trieda1 = "F004";
            trieda2 = "C106";
            profil.setImageResource(R.drawable.mariapolakova);

        }
        else if (name.equals("Ondrej") && priezvisko.equals("Rimovský")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Peter") && priezvisko.equals("Roskó")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Jana") && priezvisko.equals("Rošková")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Silvia") && priezvisko.equals("Seresová")) {
            bemutatkozo.setText(R.string.SilviaSeresováText);
            kontakt.setText("sseresova@gmail.com");
            trieda1 = "F103";
            trieda2 = "A107";

        }
        else if (name.equals("Martina") && priezvisko.equals("Sláviková")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Alexandra") && priezvisko.equals("Sochová")) {
            bemutatkozo.setText(R.string.AlexandraSochováText);
            trieda1 = "A106";
            trieda2 = "A107";

        }
        else if (name.equals("Zoltán") && priezvisko.equals("Soóky")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Marta") && priezvisko.equals("Szabóová")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Anita") && priezvisko.equals("Šaraiová")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Dagmar") && priezvisko.equals("Škrhová")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Štefan") && priezvisko.equals("Švarc")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Lucia") && priezvisko.equals("Takácsová")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Ladislav") && priezvisko.equals("Tóth")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Zoltán") && priezvisko.equals("Tóth")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Denisa") && priezvisko.equals("Veselá")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }
        else if (name.equals("Branislav") && priezvisko.equals("Výbera")) {
            trieda1 = "SC01";
            trieda2 = "D101";

        }


        Trieda1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<prizemieUcebne.length;i++) {
                    if (trieda1.equals(prizemieUcebne[i])) {
                        openPrizemie();
                    }

                }
                for (int i = 0; i < prvePoschodie.length; i++) {
                    if (trieda1.equals(prvePoschodie[i])) {
                        open1Poschodie();
                    }
                }
                for (int i = 0; i < druhePoschodie.length; i++) {
                    if (trieda1.equals(druhePoschodie[i])) {
                        open2Poschidie();
                    }

                }

                for ( int i = 0; i < sestkaA.length;i++ ){
                    if(trieda1.equals(sestkaA[i])){
                        open6A();
                    }
                }

                for ( int i = 0; i < sestkaB.length;i++ ){
                    if(trieda1.equals(sestkaB[i])){
                        open6B();
                    }
                }


                for ( int i = 0; i < sestkaC.length;i++ ){
                    if(trieda1.equals(sestkaC[i])){
                        open6C();
                    }
                }

            }
        });


        Trieda2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<prizemieUcebne.length;i++) {
                    if (trieda2.equals(prizemieUcebne[i])) {
                        openPrizemie();
                    }

                }
                for (int i = 0; i < prvePoschodie.length; i++) {
                    if (trieda2.equals(prvePoschodie[i])) {
                        open1Poschodie();
                    }
                }
                for (int i = 0; i < druhePoschodie.length; i++) {
                    if (trieda2.equals(druhePoschodie[i])) {
                        open2Poschidie();
                    }

                }

                for ( int i = 0; i < sestkaA.length;i++ ){
                    if(trieda2.equals(sestkaA[i])){
                        open6A();
                    }
                }

                for ( int i = 0; i < sestkaB.length;i++ ){
                    if(trieda2.equals(sestkaB[i])){
                        open6B();
                    }
                }


                for ( int i = 0; i < sestkaC.length;i++ ){
                    if(trieda2.equals(sestkaC[i])){
                        open6C();
                    }
                }
            }
        });








        collectionReference = db.collection(tanar);


//        private FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        private DocumentReference journaRef = db.collection("tanarok")
//                .document(tanar);
//
//        private CollectionReference collectionReference;




        sendReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* String jellemzes = review.getText().toString().trim();


                Map<String,Object> data = new HashMap<>();
                data.put("review",jellemzes);

                db.collection("tanarok")
                        .document(tanar)
                        .set(data)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                                Toast.makeText(Tanarok.this, "megment", Toast.LENGTH_SHORT).show();


                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

                */

               String text = review.getText().toString().trim();

                String text2 = text.toLowerCase();

                isCurseword = false;

                closeKeyboard();

               for(int i=0;i<szavak.length;i++){
                   if(text2.contains(szavak[i])){
                       Toast.makeText(Tanarok.this, "nem lehetett elkuldeni mert tartalmazott rossz szavat", Toast.LENGTH_SHORT).show();
                       isCurseword = true;
                   }

               }

               if (!isCurseword){
                   addThought(text);
                   arrayList.add(text);

               }

            //   addThought(text);

               review.setText("");

            }
        });

       // getToughts();



    }



    private void addThought(String jellemzes){

        //jellemzes = review.getText().toString().trim();

        Map<String,Object> data = new HashMap<>();
        data.put("review",jellemzes);

        collectionReference.add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {

                Toast.makeText(Tanarok.this, "megment", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void getToughts(){



        collectionReference.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        String data = "";


                        for(QueryDocumentSnapshot snapshots : queryDocumentSnapshots){

                            data += snapshots.getString("review")/* + "\n" + emDash + "\n"*/;
                            
                            arrayList.add(data);

                            data = "";

                        }


                        ArrayAdapter arrayAdapter = new ArrayAdapter(getBaseContext(),R.layout.cyan_text,arrayList);

                        listView.setAdapter(arrayAdapter);



                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

    }

    @Override
    protected void onStart() {
        super.onStart();
//        journaRef.addSnapshotListener(this,new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//
//                String szoveg = value.getString("jel");
//
//                kimutatas.setText(szoveg);
//
//            }

        getToughts();
//        });



    }



    public void openPrizemie() {

        Intent intent = new Intent(Tanarok.this, Prizemie.class);

        intent.putExtra("miestnost1", trieda1);
        intent.putExtra("miestnost2", trieda2);

        //



        startActivity(intent);

    }

    public void open1Poschodie() {

        Intent intent = new Intent(Tanarok.this, Prve_poschodie.class);

        intent.putExtra("miestnost1", trieda1);
        intent.putExtra("miestnost2", trieda2);

        startActivity(intent);

    }

    public void open2Poschidie() {

        Intent intent = new Intent(Tanarok.this, DruhePoschodie.class);

        intent.putExtra("miestnost1", trieda1);
        intent.putExtra("miestnost2", trieda2);

        startActivity(intent);

    }

    public void open6A() {

        Intent intent = new Intent(Tanarok.this, Sestka_a.class);

        intent.putExtra("miestnost1", trieda1);
        intent.putExtra("miestnost2", trieda2);

        startActivity(intent);

    }

    public void open6B() {

        Intent intent = new Intent(Tanarok.this, Sestka_b.class);

        intent.putExtra("miestnost1", trieda1);
        intent.putExtra("miestnost2", trieda2);

        startActivity(intent);

    }


    public void open6C() {

        Intent intent = new Intent(Tanarok.this, Sestka_c.class);

        intent.putExtra("miestnost1", trieda1);
        intent.putExtra("miestnost2", trieda2);

        startActivity(intent);

    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }



}