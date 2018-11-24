package com.example.catalinadinu.androidquiz.clase;

import java.io.Serializable;

public class Utilizator implements Serializable {
    private String nume;
    private String prenume;
    private String email;
    private String parola;
    private String tipUtilizator;


    public Utilizator(String nume, String prenume, String email, String parola, String tipUtilizator) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
        this.tipUtilizator = tipUtilizator;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nume);
        sb.append(", ");
        sb.append(prenume);
        sb.append(", ");
        sb.append(email);
        sb.append(", ");
        sb.append(parola);
        sb.append(", ");
        sb.append(tipUtilizator);
//        sb.append(tipUtilizatorProf);
//        sb.append(", ");
//        sb.append(tipUtilizatorStud);
//        sb.append(".");

        return sb.toString();
    }
}
