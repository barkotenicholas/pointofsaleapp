package com.nanodev.barkote.kiosk;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nanodev.barkote.kiosk.adapter.CustomAdapter;
import com.nanodev.barkote.kiosk.adapter.DataModel;

import java.util.ArrayList;
import java.util.Objects;


public class Productlist extends Fragment {

    public ArrayList<String> selectItems = new ArrayList<>();
    private static CustomAdapter adapter;
    private ListView listView;
    Dialog dialog;
    ArrayList<DataModel> dataModels;
    public Productlist() {
        // Required empty public constructor


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_productlist, container, false);

        dialog =new Dialog(view.getContext());



        listView = view.findViewById(R.id.productslist);


        dataModels= new ArrayList<>();

        dataModels.add(new DataModel("Apple Pie", "Android 1.0", "1","September 23, 2008","a","e"));
        dataModels.add(new DataModel("Banana Bread", "Android 1.1", "2","February 9, 2009","a","e"));
        dataModels.add(new DataModel("Cupcake", "Android 1.5", "3","April 27, 2009","a","e"));
        dataModels.add(new DataModel("Donut","Android 1.6","4","September 15, 2009","a","e"));
        dataModels.add(new DataModel("Eclair", "Android 2.0", "5","October 26, 2009","a","e"));
        dataModels.add(new DataModel("Froyo", "Android 2.2", "8","May 20, 2010","a","e"));
        dataModels.add(new DataModel("Gingerbread", "Android 2.3", "9","December 6, 2010","a","e"));
        dataModels.add(new DataModel("Honeycomb","Android 3.0","11","February 22, 2011","a","e"));
        dataModels.add(new DataModel("Ice Cream Sandwich", "Android 4.0", "14","October 18, 2011","a","e"));
        dataModels.add(new DataModel("Jelly Bean", "Android 4.2", "16","July 9, 2012","a","e"));
        dataModels.add(new DataModel("Kitkat", "Android 4.4", "19","October 31, 2013","a","e"));
        dataModels.add(new DataModel("Lollipop","Android 5.0","21","November 12, 2014","a","e"));
        dataModels.add(new DataModel("Marshmallow", "Android 6.0", "23","October 5, 2015","a","e"));

        adapter= new CustomAdapter(dataModels,getActivity().getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new     AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                showPop();

            }
        });

        return view;

    }

    private void showPop() {

        dialog.setContentView(R.layout.pop_up_product);
    }

}


