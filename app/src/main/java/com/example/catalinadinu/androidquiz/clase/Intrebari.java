package com.example.catalinadinu.androidquiz.clase;

public class Intrebari {

    public String listaIntrebari[] = {
            "Gestiunea fisierelor este o functie a?",
            "Care nu este un sistem de operare?",
            "Capacitatea de reprezentare a unui hard disk este reprezentata prin:",
            "Cat ocupa o variabila de tip long double?",
            "Aplicatiile JAVA ruleaza pe:",
            "Constructorul se foloseste la:"

    };

    private String listaGrile[][] = {
            {"hard diskului", "sistemului de operare", "placii de baza", "placii de retea"},
            {"Windows", "Unix",
                    "Office", "Android"},
            {"gb", "ghz", "biti", "pixeli"},
            {"8 bytes", "4 byutes", "2 bytes", "10 bytes"},
            {"windows", "linux", "unix", "toate cele 3"},
            {"Eliberarea memoriei", "Importarea de pachete", "Initializarea masinii virtuale", "Initializarea de noi obiecte create"}

    };

    private String raspsunsuriCorecte[] = {
            "sistemului de operare", "Office",
            "gb", "8 bytes", "toate cele 3", "Initializarea de noi obiecte create"
    };
    public String obtineIntrebare(int i)
    {
        String intrebare = listaIntrebari[i];
        return  intrebare;
    }
    public String obtineGrila1(int i)
    {
        String alegere = listaGrile[i][0];
        return alegere;
    }
    public String obtineGrila2(int i)
    {
        String alegere = listaGrile[i][1];
        return alegere;
    }
    public String obtineGrila3(int i)
    {
        String alegere = listaGrile[i][2];
        return alegere;
    }
    public String obtineGrila4(int i) 
    {
        String alegere = listaGrile[i][3];
        return alegere;
    }
    public String obtineRaspCorect(int i)
    {
        String raspuns = raspsunsuriCorecte[i];
        return raspuns;
    }
}
