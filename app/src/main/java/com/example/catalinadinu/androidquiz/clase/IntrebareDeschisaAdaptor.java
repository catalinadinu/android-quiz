package com.example.catalinadinu.androidquiz.clase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.catalinadinu.androidquiz.R;

import java.util.ArrayList;
import java.util.HashMap;

public class IntrebareDeschisaAdaptor extends BaseAdapter {
    private Context mContext;
    private ArrayList<IntrebareDeschisa> intrebari;
    private HashMap<String,Integer> itemStates;

    public IntrebareDeschisaAdaptor(Context mContext, ArrayList<IntrebareDeschisa> intrebari) {
        this.mContext = mContext;
        this.intrebari=intrebari;
        this.itemStates=new HashMap<>();

        for(IntrebareDeschisa intrebare : intrebari){
            itemStates.put(intrebare.getTextIntrebare(), intrebare.getId());
        }
    }

    @Override
    public int getCount() {
        return intrebari.size();
    }

    @Override
    public Object getItem(int position) {
        return intrebari.get(position);
    }

    @Override
    public long getItemId(int position) {
        return intrebari.get(position).getId();
    }

    @Override
    public View getView(int position, View listView, ViewGroup parent) {
        if(listView == null){
            listView=LayoutInflater.from(mContext).inflate(R.layout.list_item_raspdeschis, parent, false);
        }

        TextView txtId = listView.findViewById(R.id.id);
        TextView txtTxt = listView.findViewById(R.id.textIntrebare);

        final IntrebareDeschisa intrebare=(IntrebareDeschisa) getItem(position);

        txtId.setText("Intrebarea "+ intrebare.getId().toString());
        txtTxt.setText(intrebare.getTextIntrebare());

        return listView;
    }
}
