package com.pls.spojenapp.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.pls.spojenapp.MainActivity;
import com.pls.spojenapp.R;
import com.pls.spojenapp.ui.gallery.GalleryFragment;

import java.util.Locale;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    Button magyar;
    Button szlovak;
    Button angol;
    GalleryFragment pls;
    String nyelv;
    ConstraintLayout mConstraintLayout, loginConst, loginHatter;
    AnimationDrawable mAnimationDrawable;
    ImageView logo;
    Button login;
    EditText password;
    Boolean checkAllapot;
    CheckBox rembemerMe;
    String jelszo="",jelszo2="";
    DrawerLayout mDrawerLayout;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        // final TextView textView = root.findViewById(R.id.text_home);
      /*  homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/


        //gallery = root.findViewById(R.id.nav_gallery);
        // gallery= inflater.inflate(R.id.nav_gallery, container, false);


        magyar = root.findViewById(R.id.button8);
        szlovak = root.findViewById(R.id.button11);
        angol = root.findViewById(R.id.button12);
        logo = root.findViewById(R.id.textView3);
        login = root.findViewById(R.id.button194);
        loginConst = root.findViewById(R.id.logincucc);
        password = root.findViewById(R.id.jelszo);
        rembemerMe = root.findViewById(R.id.checkBox);
        loginHatter = root.findViewById(R.id.csicskavokhelo);
        pls = (GalleryFragment) getParentFragmentManager().findFragmentById(R.id.nav_gallery);
        mConstraintLayout = root.findViewById(R.id.layout);


        mAnimationDrawable = (AnimationDrawable) mConstraintLayout.getBackground();

        mAnimationDrawable.setEnterFadeDuration(2000);
        mAnimationDrawable.setExitFadeDuration(4000);
        mAnimationDrawable.start();

        loadData();
        updateViews();


        //((MainActivity)getActivity()).setDrawer_Locked();







        if(rembemerMe.isChecked() && jelszo.equals("abc123") ){


            loginKommandok();
            saveData();

       }
        else{

           magyar.setVisibility(View.GONE);
           szlovak.setVisibility(View.GONE);
           angol.setVisibility(View.GONE);
           loginHatter.setVisibility(View.VISIBLE);
//        logo.setVisibility(View.GONE);
           ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
           ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable((new ColorDrawable(Color.parseColor("#033902"))));
            ((MainActivity)getActivity()).setDrawer_Locked();

            


       }

        rembemerMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                saveData();
            }
        });

        if(jelszo2.equals("abc123")){

            loginKommandok();


        }






        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jelszo = password.getText().toString();
                jelszo2 = password.getText().toString();

                if (jelszo.equals("abc123")) {

                 //   InputMethodManager inputManager = (InputMethodManager) (Context.INPUT_METHOD_SERVICE);

                   // inputManager.hideSoftInputFromWindow(password.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                    loginKommandok();
                    closeKeyboard();
                    saveData();


                    //   logo.setVisibility(View.VISIBLE);
                }
                else {

                    Toast.makeText(getContext(), R.string.login, Toast.LENGTH_SHORT).show();
                }

            }
        });






        magyar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setLocale("hu");
             requireActivity().recreate();


                saveData();

            }
        });


        szlovak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setLocale("sk");
                requireActivity().recreate();



                saveData();

            }
        });

        angol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setLocale("en");
                requireActivity().recreate();



                saveData();

            }
        });



      /*  getFragmentManager().beginTransaction().replace(R.id.nav_home, homefragment, "Your_Fragment_TAG").commitAllowingStateLoss();





        Fragment frag = null;
        frag = getFragmentManager().findFragmentByTag("Your_Fragment_TAG");
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.detach(frag);
        fragmentTransaction.attach(frag);
        fragmentTransaction.commit();*/









       // requireActivity().recreate();






        return root;


    }




    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getContext().getResources().updateConfiguration(config, getContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getContext().getSharedPreferences("Settings", Context.MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    public void loadLocale() {
        SharedPreferences prefs = getContext().getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocale(language);
    }

    public void saveData() {

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("valami", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("check", rembemerMe.isChecked());
        editor.putString("kod",jelszo);



        editor.apply();
    }

    public void loadData() {

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("valami", Context.MODE_PRIVATE);

        checkAllapot = sharedPreferences.getBoolean("check",false);
        jelszo = sharedPreferences.getString("kod","");



    }

    public void updateViews() {


        rembemerMe.setChecked(checkAllapot);



    }

    private void closeKeyboard() {

        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);

    }

    private void loginKommandok(){

        loginConst.setVisibility(View.GONE);
        magyar.setVisibility(View.VISIBLE);
        szlovak.setVisibility(View.VISIBLE);
        angol.setVisibility(View.VISIBLE);
        loginHatter.setVisibility(View.GONE);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable((new ColorDrawable(Color.parseColor("#008000"))));
        ((MainActivity)getActivity()).setDrawer_UnLocked();


    }


}
