package com.example.catalinadinu.androidquiz;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
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
    //private RadioButton radioButtonTipUtil;
    //private Button butonCreareCont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inregistrare);

        nume=findViewById(R.id.id_numeInregistrare);
        prenume=findViewById(R.id.id_prenumeInregistrare);
        email=findViewById(R.id.id_mailInregistrare);
        parola=findViewById(R.id.id_parolaInregistrare);
        radioGroupTip = findViewById(R.id.id_radioGrup);

        //addListenerOnButton();
    }

//    public void addListenerOnButton(){
//
//        butonCreareCont.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                int selectedId = radioGroupTip.getCheckedRadioButtonId();
//                radioButtonTipUtil = findViewById(selectedId);
//                Toast.makeText(Inregistrare.this, radioButtonTipUtil.getText(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

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


    public void creeazaCont(View view)
    {
        if(nume!=null && prenume!=null && email!=null && parola!=null && radioGroupTip.getCheckedRadioButtonId() != -1)
        {
            if("".equals(nume.getText().toString()) || "".equals(prenume.getText().toString()) ||
                    "".equals(email.getText().toString()) || "".equals(parola.getText().toString()) ||
                    "".equals(nume.getText().toString()) || radioGroupTip.getCheckedRadioButtonId() == -1)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Eroare");
                builder.setMessage("Toate campurile sunt obligatorii!");
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else
            {
                String radioValue = ((RadioButton)findViewById(radioGroupTip.getCheckedRadioButtonId())).getText().toString();
                Utilizator utilizator = new Utilizator(nume.getText().toString(),prenume.getText().toString(), email.getText().toString(),
                        parola.getText().toString(), radioValue);
                //Toast.makeText(Inregistrare.this, utilizator.toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("util", utilizator);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}
