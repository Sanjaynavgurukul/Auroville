package com.solution.transport.transport_solution;

import android.app.Person;
import android.content.Context;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<CustomAdapter> {

    private Context mContext;
    int Resourse;

    public CustomArrayAdapter(Context context, int resource, ArrayList<CustomAdapter> objects) {
        super(context, resource, objects);
        mContext = context;
        Resourse = resource;

    }


    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        String numberOfDays = getItem(position).getnDays();
        String totalMoney = getItem(position).getPricePerDay();
        int id = getItem(position).getId();

        CustomAdapter customAdapter = new CustomAdapter(numberOfDays, totalMoney,id);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(Resourse , parent , false);

        TextView textView = convertView.findViewById(R.id.day);
        TextView textView2 = convertView.findViewById(R.id.prize);

        textView.setText(numberOfDays + " " + "Days");
        textView2.setText(totalMoney + " " + "Rs. / days");

        return convertView;

    }
}
