package com.example.catalinadinu.androidquiz.clase;

public class ProfPartajare {
    public String nume;
    public String prenume;
    public String materie;

    public String getMaterie() {
        return materie;
    }

    public ProfPartajare() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nume);
        sb.append(" ");
        sb.append(prenume);
        sb.append(" - ");
        sb.append(materie);
        return sb.toString();
    }
}
