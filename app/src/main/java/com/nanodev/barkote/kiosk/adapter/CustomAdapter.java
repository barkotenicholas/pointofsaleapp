package com.nanodev.barkote.kiosk.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.nanodev.barkote.kiosk.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<DataModel> {

    Context mContext;
    private ArrayList<DataModel> dataSet;
    private int lastPosition = -1;

    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.productlayout, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        LayoutInflater inflater = LayoutInflater.from(mContext);

        View result;

        viewHolder = new ViewHolder();

        result = inflater.inflate(R.layout.productlayout, null, true);
        viewHolder.txtName = result.findViewById(R.id.name);
        viewHolder.txtType = result.findViewById(R.id.type);
        viewHolder.desncriptio = result.findViewById(R.id.description);
        viewHolder.price = result.findViewById(R.id.price);
        viewHolder.quantity = result.findViewById(R.id.textView7);
        viewHolder.checkBox = result.findViewById(R.id.checkBox);

        result.setTag(viewHolder);


        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        assert dataModel != null;
        viewHolder.txtName.setText(dataModel.getA());
        viewHolder.txtType.setText(dataModel.getB());
        viewHolder.desncriptio.setText(dataModel.getC());
        viewHolder.price.setText(dataModel.getD());
        viewHolder.quantity.setText(dataModel.getE());

        viewHolder.txtType.setTag(position);

        // Return the completed view to render on screen
        return result;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtType;
        TextView desncriptio;
        TextView price;
        TextView quantity;
        CheckBox checkBox;

    }
}
