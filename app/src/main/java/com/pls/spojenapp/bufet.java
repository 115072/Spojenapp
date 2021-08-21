package com.pls.spojenapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gjiazhe.panoramaimageview.GyroscopeObserver;
import com.gjiazhe.panoramaimageview.PanoramaImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link bufet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bufet extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public bufet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment bufet.
     */
    // TODO: Rename and change types and number of parameters
    public static bufet newInstance(String param1, String param2) {
        bufet fragment = new bufet();
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

    GyroscopeObserver gyros;
    PanoramaImageView panor;
    Button elore;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_bufet, container, false);

        gyros = new GyroscopeObserver();
        gyros.setMaxRotateRadian(Math.PI/2);


        panor = root.findViewById(R.id.panorama);
        elore = root.findViewById(R.id.button195);
        panor.setGyroscopeObserver(gyros);


        elore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                panor.setImageResource(R.drawable.szobam);
            }
        });



        return root;
    }


    @Override
    public void onResume() {
        super.onResume();
        gyros.register(getContext());
    }

    @Override
    public void onPause() {
        super.onPause();
        gyros.unregister();
    }
}