package com.nanodev.barkote.kiosk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;


public class Productlist extends Fragment {

    public ArrayList<String> selectItems = new ArrayList<>();

    private ListView listView;

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

        listView = view.findViewById(R.id.productslist);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        String[] items = {"Mayai", "Ndengu", "Spinach"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Objects.requireNonNull(getActivity()),R.layout.productlayout,R.id.txt_lan,items);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((TextView) view).getText().toString();

            }
        });

        return view;

    }

}


