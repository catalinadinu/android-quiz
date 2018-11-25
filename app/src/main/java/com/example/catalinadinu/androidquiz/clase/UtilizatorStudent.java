package com.example.catalinadinu.androidquiz.clase;

import java.io.Serializable;

public class UtilizatorStudent implements Serializable {
    private String nume;
    private String prenume;
    private String email;
    private String parola;
    private String confirmaParola;

    public UtilizatorStudent(String nume, String prenume, String email, String parola, String confirmaParola) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
        this.confirmaParola=confirmaParola;
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
        sb.append(confirmaParola);
        return sb.toString();
    }
}
