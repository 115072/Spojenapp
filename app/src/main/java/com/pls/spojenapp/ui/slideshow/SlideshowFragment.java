package com.pls.spojenapp.ui.slideshow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.pls.spojenapp.ExampleItem;
import com.pls.spojenapp.R;
import com.pls.spojenapp.Tanarok;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {

    GridView gridView;
   private String[] names = {/*"Gabriela","Katarína","Emőke","Andrea","Viktória","Bálint","Peter","Ildikó","Lenka","Imrich","Jozef","Katarína","Ladislav","László","Karol","Juliana","Koloman","František","Peter","Erika","Lucia","Márius","Aneta","Roman","Silvia","Ladislav","Katarína", "Imrich","Peter","Ladislav","Michal","Melinda","Martin","Tibor","Ildikó","Zuzana","Marian","Katarína","Ivan","Mária","Ondrej","Peter","Jana","Silvia","Martina","Alexandra","Zoltán","Marta","Anita","Dagmar","Štefan","Lucia","Ladislav","Zoltán","Denisa","Branislav"*/"Antonio","Jennifer","Michael","Antonio","Jennifer","Michael","Antonio","Jennifer","Michael","Antonio","Jennifer","Michael","Antonio","Jennifer","Michael","Antonio","Jennifer","Michael","Antonio","Jennifer","Michael","Antonio","Jennifer","Michael","Antonio","Jennifer","Michael","Antonio","Jennifer","Michael","Antonio","Jennifer","Michael","Antonio","Jennifer","Michael","Antonio","Jennifer","Michael","Antonio","Jennifer","Michael","Antonio","Jennifer","Michael","Antonio","Jennifer","Michael"};
   private String[] priezvisko = {/*"Alexovič","Antošíková","Benková","Caliskan","Csepedi","Csörgő","Cucor","Dallosová","Danácsová","Dékány","Elek","Fabuľová","Ferencz","Forró","Gelle","Gyuríková","Halász","Hortai","Hudec","Jóbová","Kálaziová","Karadi","Katonová","Keszeg","Kollárová","Korinek","Košnarová","Kovács","Lénárt","Lencsés","Miko","Mojzešová","Molnár","Molnár","Németh","Nováková","Otruba","Pokorná","Polák","Poláková","Rimovský","Roskó","Rošková","Seresová","Sláviková","Sochová","Soóky","Szabóová","Šaraiová","Škrhová","Švarc","Takácsová","Tóth","Tóth","Veselá","Výbera"*/"Montana","Lopez","Jordan","Montana","Lopez","Jordan","Montana","Lopez","Jordan","Montana","Lopez","Jordan","Montana","Lopez","Jordan","Montana","Lopez","Jordan","Montana","Lopez","Jordan","Montana","Lopez","Jordan","Montana","Lopez","Jordan","Montana","Lopez","Jordan","Montana","Lopez","Jordan","Montana","Lopez","Jordan","Montana","Lopez","Jordan","Montana","Lopez","Jordan","Montana","Lopez","Jordan","Montana","Lopez","Jordan"};

     private List<ExampleItem> itemsModalList = new ArrayList<>();



CustomAdapter customadapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel = ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        // final TextView textView = root.findViewById(R.id.text_slideshow);
       /* slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        setHasOptionsMenu(true);
       gridView = root.findViewById(R.id.gridView);

       for (int i =0; i< names.length;i++){
           ExampleItem itemsModal = new ExampleItem(names[i],priezvisko[i]);
           itemsModalList.add(itemsModal);
       }

       customadapter = new CustomAdapter(itemsModalList,getContext());

       gridView.setAdapter(customadapter);


        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        requireActivity().getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem = menu.findItem(R.id.searchView);

        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
             //   Log.e("TAG","new text ==> " + newText);

                customadapter.getFilter().filter(newText);
                return true;
            }
        });




        super.onCreateOptionsMenu(menu, inflater);
    }



    public class CustomAdapter extends BaseAdapter implements Filterable{
        private List<ExampleItem> itemsModalList;
        private List<ExampleItem> itemsModalListFilter;
        private Context context;


        public CustomAdapter(List<ExampleItem> itemsModalList, Context context) {
            this.itemsModalList = itemsModalList;
            this.itemsModalListFilter = itemsModalList;
            this.context = context;

        }

        @Override
        public int getCount() {
            return itemsModalList.size();
        }

        @Override
        public Object getItem(int position) {
            return itemsModalList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = convertView;

            final ExampleItem itemsModal = itemsModalList.get(position);

            if(view1 == null) {
                view1 = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false);
            }



            TextView tvName = view1.findViewById(R.id.tvName);
            TextView tvPriezvisko = view1.findViewById(R.id.tvPriezvisko);

            String name = itemsModal.getText1();
            String priezvisko =  itemsModal.getText2();

            tvName.setText(name);
            tvPriezvisko.setText(priezvisko);


            view1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                //    Log.e("CLICKED ITEM"," ==> " + itemsModal.getText1());
                //    Log.e("CLICKED ITEM"," ==> " + itemsModal.getText2());
                    startActivity(new Intent(getContext(),Tanarok.class).putExtra("data",itemsModal));
                }
            });

            return view1;


        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if(constraint == null || constraint.length() == 0){

                        filterResults.count = itemsModalListFilter.size();
                        filterResults.values = itemsModalListFilter;

                    }
                    else {
                        String searchChr = constraint.toString().toLowerCase();
                        List<ExampleItem> searchResult = new ArrayList<>();

                        for (ExampleItem itemsModal:itemsModalListFilter){
                            if(itemsModal.getText1().toLowerCase().contains(searchChr) || itemsModal.getText2().toLowerCase().contains(searchChr) ){
                                searchResult.add(itemsModal);
                            }
                        }

                        filterResults.count = searchResult.size();
                        filterResults.values = searchResult;
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {

                    itemsModalList = (List<ExampleItem>) results.values;
                    notifyDataSetChanged();



                }
            };
            return filter;
        }
    }


}




