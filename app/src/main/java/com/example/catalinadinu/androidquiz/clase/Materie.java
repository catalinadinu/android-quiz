package com.example.catalinadinu.androidquiz.clase;

public class Materie {
    public String denumire;
    public String an;
    public String tipExaminare;
    public String semestru;

    public Materie() {
    }

    public Materie(String denumire, String an, String tipExaminare, String semestru) {
        this.denumire = denumire;
        this.an = an;
        this.tipExaminare = tipExaminare;
        this.semestru = semestru;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(denumire);
        sb.append(", ");
        sb.append("an: " + an);
        sb.append(", ");
        sb.append("semestru: "+semestru);
        sb.append(", ");
        sb.append(tipExaminare);
        return sb.toString();

    }
}
