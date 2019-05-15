package com.nanodev.barkote.kiosk;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fxn769.Numpad;
import com.nanodev.barkote.kiosk.adapter.DataModel;

public class ItemChooser extends BottomSheetDialogFragment {
    public DataModel dataModel;
    TextView txt, remaining_digit, name, reatail, left;
    Numpad numpad;
    Button save,cancel;
    private FragmentActivity myContext;
    @Nullable
    private Boo boo;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View v = inflater.inflate(R.layout.pop_up_product, null);
        numpad = v.findViewById(R.id.num);
        name = v.findViewById(R.id.productname);
        reatail = v.findViewById(R.id.priceProduct);
        Bundle b = this.getArguments();

        assert b != null;


        dataModel = b.getParcelable("Detail");
        txt = v.findViewById(R.id.txt);
        remaining_digit = v.findViewById(R.id.remaining_digit);
        left = v.findViewById(R.id.quantityleft);
        save = v.findViewById(R.id.save);
        cancel = v.findViewById(R.id.cancel_action);

        name.setText(dataModel.getA());
        reatail.setText(dataModel.getC());
        left.setText(dataModel.getB());
        numpad.setOnTextChangeListner((String text, int digits_remaining) -> {
            if (text.length() == 0) {
                remaining_digit.setText("");
            } else {
                remaining_digit.setText("");
            }
            txt.setText(text);
        });



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToCart();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             dismiss();
            }
        });
        return v;
    }

    private void sendToCart() {

        String a = txt.getText().toString();

        if(a.isEmpty()){
            remaining_digit.setText("Please input a value ");
        }else {
            int b = Integer.parseInt(a);
            Toast.makeText(getContext(),"THE INT VALUE IS "+b,Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        getDialog().getWindow().setGravity(Gravity.BOTTOM);


    }

    public interface Boo {
        void onclick(String a);
    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }
}
