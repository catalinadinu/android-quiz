package com.example.catalinadinu.androidquiz.clase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.catalinadinu.androidquiz.R;

import java.util.ArrayList;
import java.util.List;


public class TesteAdaptorPersonalizat extends ArrayAdapter<Test> {
    private ArrayList<Test> teste;

    public TesteAdaptorPersonalizat(Context context, int resource, List<Test> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_view_item_test, null);
        }

        TextView nume = convertView.findViewById(R.id.numeTest);
        TextView nrIntrebari = convertView.findViewById(R.id.nrIntrebariTest);

        Test t = getItem(position);

        nume.setText(t.getNumeTest());
        nrIntrebari.setText(t.getNrIntrebari() + " întrebări");

        return convertView;
    }

}
