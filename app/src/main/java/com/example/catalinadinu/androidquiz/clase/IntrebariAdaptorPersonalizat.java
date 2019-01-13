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

public class IntrebariAdaptorPersonalizat extends BaseAdapter {
    private Context mContext;
    private ArrayList<Intrebare> intrebari;
    private HashMap<String,Integer> itemStates;

    public IntrebariAdaptorPersonalizat(Context mContext, ArrayList<Intrebare> intrebari) {
        this.mContext = mContext;
        this.intrebari=intrebari;
        this.itemStates=new HashMap<>();

        for(Intrebare intrebare : intrebari){
            itemStates.put(intrebare.getTextIntrebare(), intrebare.getRaspunsCorect());
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
            listView=LayoutInflater.from(mContext).inflate(R.layout.list_item_intrebare, parent, false);
        }

        TextView txtId = listView.findViewById(R.id.id);
        TextView txtTxt = listView.findViewById(R.id.textIntrebare);
        TextView rasp1=listView.findViewById(R.id.raspuns1);
        TextView rasp2=listView.findViewById(R.id.raspuns2);
        TextView rasp3=listView.findViewById(R.id.raspuns3);
        //TextView corect=listView.findViewById(R.id.raspunsCorect);

        final Intrebare intrebare=(Intrebare) getItem(position);

        txtId.setText("Intrebarea "+ intrebare.getId().toString());
        txtTxt.setText(intrebare.getTextIntrebare());
        rasp1.setText("a:"+intrebare.getRaspuns(0));
        rasp2.setText("b:"+intrebare.getRaspuns(1));
        rasp3.setText("c:"+intrebare.getRaspuns(2));

//        if(intrebare.getRaspunsCorect()==0)
//        {
//            corect.setText("Raspunsul corect este A");
//        }
//        else if (intrebare.getRaspunsCorect()==1)
//        {
//            corect.setText("Raspunsul corect este B");
//        }
//        else if (intrebare.getRaspunsCorect()==2)
//        {
//            corect.setText("Raspunsul corect este C");
//        }

        return listView;
    }
}
