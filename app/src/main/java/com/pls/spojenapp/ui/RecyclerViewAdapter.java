package com.pls.spojenapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.pls.spojenapp.R;
import com.pls.spojenapp.ReciclerViewhezKonsGet;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends FirestoreRecyclerAdapter<ReciclerViewhezKonsGet, RecyclerViewAdapter.RecyclerViewAdapterHolder>{

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public RecyclerViewAdapter(@NonNull FirestoreRecyclerOptions<ReciclerViewhezKonsGet> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull RecyclerViewAdapterHolder recyclerViewAdapterHolder, int i, @NonNull ReciclerViewhezKonsGet reciclerViewhezKonsGet) {
        recyclerViewAdapterHolder.nev.setText(reciclerViewhezKonsGet.getNev());
        recyclerViewAdapterHolder.pontok.setText(String.valueOf(reciclerViewhezKonsGet.getPontok()));
    }

    @NonNull
    @Override
    public RecyclerViewAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row,
                parent,false);
        return new RecyclerViewAdapterHolder(v);
    }

    class RecyclerViewAdapterHolder extends RecyclerView.ViewHolder{

        TextView nev;
        TextView pontok;

        public RecyclerViewAdapterHolder(@NonNull View itemView) {
            super(itemView);

            nev = itemView.findViewById(R.id.nev);
            pontok = itemView.findViewById(R.id.pont);
        }
    }
}



















































































 /*public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    Context context;
    String[] nevek;
    String[] pontok;
    String[] helyezes;
    ArrayList<String> nev;



    public RecyclerViewAdapter(Context context, ArrayList<String> nev, String[] pontok, String[] helyezes) {
        this.context = context;
        this.nev = nev;
        this.pontok = pontok;
        this.helyezes = helyezes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(helyezes[position]);
        holder.text2.setText(nev.get(position));
        holder.text3.setText(pontok[position]);

    }

    @Override
    public int getItemCount() {
        return helyezes.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text1,text2,text3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            text1 = itemView.findViewById(R.id.helyezes);
            text2 = itemView.findViewById(R.id.nev);
            text3 = itemView.findViewById(R.id.pont);
        }
    }
}*/
