package com.example.catalinadinu.androidquiz.clase;

import java.util.ArrayList;

public class Intrebare {
    private Integer id;
    private String textIntrebare;
    private ArrayList<String> raspunsuri;
    private Integer raspunsCorect;

    public Intrebare(Integer id, String textIntrebare, ArrayList<String> raspunsuri) {
        this.id = id;
        this.textIntrebare = textIntrebare;
        this.raspunsuri = raspunsuri;
    }

    public Intrebare(Integer id, String textIntrebare, ArrayList<String> raspunsuri, Integer raspunsCorect) {
        this.id = id;
        this.textIntrebare = textIntrebare;
        this.raspunsuri = raspunsuri;
        this.raspunsCorect = raspunsCorect;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextIntrebare() {
        return textIntrebare;
    }

    public void setTextIntrebare(String textIntrebare) {
        this.textIntrebare = textIntrebare;
    }

    public ArrayList<String> getRaspunsuri() {
        return raspunsuri;
    }

    public void setRaspunsuri(ArrayList<String> raspunsuri) {
        this.raspunsuri = raspunsuri;
    }

    public String getRaspuns(Integer x)
    {
        return raspunsuri.get(x);
    }

    public Integer getRaspunsCorect() {
        return raspunsCorect;
    }

    public void setRaspunsCorect(Integer raspunsCorect) {
        this.raspunsCorect = raspunsCorect;
    }

    @Override
    public String toString() {
        return "Intrebare{" +
                "id=" + id +
                ", textIntrebare='" + textIntrebare + '\'' +
                ", raspunsuri=" + raspunsuri +
                ", raspunsCorect=" + raspunsCorect +
                '}';
    }
}
