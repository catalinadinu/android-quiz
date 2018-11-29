package com.example.catalinadinu.androidquiz.clase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.catalinadinu.androidquiz.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class StudentiAdaptorPersonalizat extends ArrayAdapter<UtilizatorStudent> {
   private ArrayList<UtilizatorStudent> studenti;
   //private static HashMap<String, String> itemStates;

    public StudentiAdaptorPersonalizat(Context context, int resource, List<UtilizatorStudent> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_view_item, null);
        }

        TextView nume = convertView.findViewById(R.id.nume);
        TextView prenume = convertView.findViewById(R.id.prenume);
        TextView cod = convertView.findViewById(R.id.cod);

        UtilizatorStudent student = getItem(position);

        nume.setText(student.getNume());
        prenume.setText(student.getPrenume());
        cod.setText(student.getCodStudent());

        return convertView;
    }


}
