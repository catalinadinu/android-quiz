package com.example.catalinadinu.androidquiz;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.clase.Utilizator;

public class Inregistrare extends AppCompatActivity {

    private EditText nume;
    private EditText prenume;
    private EditText email;
    private EditText parola;
    private RadioGroup radioGroupTip;
    private RadioButton radioButtonTipUtil;
    private Button butonCreareCont;
//    private RadioButton tipUtilizatorProf;
//    private RadioButton tipUtilizatorStud;
   // private String tipUtilizator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inregistrare);

        nume=findViewById(R.id.id_numeInregistrare);
        prenume=findViewById(R.id.id_prenumeInregistrare);
        email=findViewById(R.id.id_mailInregistrare);
        parola=findViewById(R.id.id_parolaInregistrare);
//        tipUtilizatorProf=findViewById(R.id.id_profilProf);
//        tipUtilizatorStud=findViewById(R.id.id_profilStud);
//        tipUtilizator=findViewById(R.id.id_radioGrup);

        addListenerOnButton();
    }

    public void addListenerOnButton(){
        radioGroupTip = (RadioGroup) findViewById(R.id.id_radioGrup);
        butonCreareCont = findViewById(R.id.buttonInregistrare);

        butonCreareCont.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int selectedId = radioGroupTip.getCheckedRadioButtonId();
                radioButtonTipUtil = findViewById(selectedId);
                Toast.makeText(Inregistrare.this, radioButtonTipUtil.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onRadioButtonClicked(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId())
        {
            case(R.id.id_profilProf):
                if(checked)
                    break;
            case(R.id.id_profilStud):
                if(checked)
                    break;
        }
    }

//    String getTipUtilizator()
//    {
//        if(tipUtilizatorProf.isSelected())
//        {
//
//        }
//    }
//
//    public void creeazaCont(View view)
//    {
//        if(nume!=null && prenume!=null && email!=null && parola!=null
//                && (tipUtilizatorProf.isChecked() || tipUtilizatorStud.isChecked()))
//        {
//            if("".equals(nume.getText().toString()) || "".equals(prenume.getText().toString()) ||
//                    "".equals(email.getText().toString()) || "".equals(parola.getText().toString()) ||
//                    "".equals(nume.getText().toString()) ||
//                    (tipUtilizatorProf.isChecked() == false && tipUtilizatorStud.isChecked()==false))
//            {
//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setTitle("Eroare");
//                builder.setMessage("Toate campurile sunt obligatorii!");
//                builder.setPositiveButton("OK", null);
//                AlertDialog dialog = builder.create();
//                dialog.show();
//            }
//            else
//            {
//                Utilizator utilizator = new Utilizator(nume.getText().toString(),prenume.getText().toString(), email.getText().toString(),
//                        parola.getText().toString(), Boolean.getBoolean(tipUtilizatorProf), Boolean.getBoolean(tipUtilizatorStud));
//            }
//        }
//    }
}
