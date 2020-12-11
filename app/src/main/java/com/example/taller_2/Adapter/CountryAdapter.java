package com.example.taller_2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.taller_2.Model.Country;
import com.example.taller_2.R;

import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter<Country> {
    public CountryAdapter(Context context, ArrayList<Country> data) {
        super(context, R.layout.list_item, data);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_item, null);
        TextView lblCountry = (TextView) item.findViewById(R.id.lblCountry);
        TextView txtNewConfirmed = (TextView) item.findViewById(R.id.txtNewConfirmed);
        TextView txtNewRecovered = (TextView) item.findViewById(R.id.txtNewRecovered);
        TextView txtNewDeaths = (TextView) item.findViewById(R.id.txtNewDeaths);
        TextView txtTotalConfirmed = (TextView) item.findViewById(R.id.txtTotalConfirmed);
        TextView txtTotalRecovered = (TextView) item.findViewById(R.id.txtTotalRecovered);
        TextView txtTotalDeaths = (TextView) item.findViewById(R.id.txtTotalDeaths);

        lblCountry.setText(getItem(position).getName());
        txtNewConfirmed.setText(getItem(position).getNewConfirmed());
        txtNewRecovered.setText(getItem(position).getNewRecovered());
        txtNewDeaths.setText(getItem(position).getNewDeaths());
        txtTotalConfirmed.setText(getItem(position).getTotalConfirmed());
        txtTotalRecovered.setText(getItem(position).getTotalRecovered());
        txtTotalDeaths.setText(getItem(position).getTotalDeaths());

        return(item);
    }
}
