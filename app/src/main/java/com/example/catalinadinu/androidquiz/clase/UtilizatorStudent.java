package com.example.catalinadinu.androidquiz.clase;

import java.io.Serializable;

public class UtilizatorStudent implements Serializable {
    private String nume;
    private String prenume;
    private String email;
    private String parola;
    private String confirmaParola;
    private String codStudent;

    public String getCodStudent() {
        return codStudent;
    }

    public UtilizatorStudent(String nume, String prenume, String email, String codStudent) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.codStudent = codStudent;
    }

    public void setCodStudent(String codStudent) {
        this.codStudent = codStudent;
    }

    public UtilizatorStudent(String nume, String prenume, String email, String parola, String confirmaParola) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
        this.confirmaParola=confirmaParola;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getConfirmaParola() {
        return confirmaParola;
    }

    public void setConfirmaParola(String confirmaParola) {
        this.confirmaParola = confirmaParola;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nume);
        sb.append(", ");
        sb.append(prenume);
        sb.append(", ");
        sb.append(email);
      //  sb.append(", ");
//        sb.append(parola);
//        sb.append(", ");
//        sb.append(confirmaParola);
        return sb.toString();
    }
}
