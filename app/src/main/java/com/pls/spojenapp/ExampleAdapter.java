/*package com.example.spojenapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spojenapp.ExampleItem;

import java.util.ArrayList;
import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> implements Filterable{
    private ArrayList<ExampleItem> mExamplelist;
    private ArrayList<ExampleItem> exampleListFull;



    private OnItemClickListener mListener;



    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener){
        mListener = listener;

    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView1;
        public TextView mTextView2;

        public ExampleViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            mTextView1 = itemView.findViewById(R.id.textView_recycle);
            mTextView2 = itemView.findViewById(R.id.textView2_recycle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }

                }
            });

        }
    }

    public  ExampleAdapter(ArrayList<ExampleItem> examplelist) {
        mExamplelist = examplelist;
        exampleListFull = new ArrayList<>(examplelist);



    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item_row_items,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExamplelist.get(position);

        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());

    }

    @Override
    public int getItemCount() {
        return mExamplelist.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ExampleItem> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(exampleListFull);
            }
            else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ExampleItem item : exampleListFull){
                  if(item.getText1().toLowerCase().contains(filterPattern)){
                      filteredList.add(item);
                  }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mExamplelist.clear();
            mExamplelist.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };

    public void filterList(ArrayList<ExampleItem> filteredList) {

        mExamplelist = filteredList;
        notifyDataSetChanged();
    }



}

 */

