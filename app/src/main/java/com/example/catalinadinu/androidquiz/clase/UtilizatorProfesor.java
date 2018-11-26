package com.example.catalinadinu.androidquiz.clase;


import java.io.Serializable;

public class UtilizatorProfesor implements Serializable {
    private String nume;
    private String prenume;
    private String email;
    private String parola;
    private String confirmaParola;
    private String cod;



    public UtilizatorProfesor(String nume, String prenume, String email, String parola, String confirmaParola) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
        this.confirmaParola=confirmaParola;
    }

    public UtilizatorProfesor(String email, String parola, String cod) {
        this.email = email;
        this.parola = parola;
        this.cod = cod;
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
