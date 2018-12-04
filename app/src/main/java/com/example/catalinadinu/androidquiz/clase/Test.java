package com.example.catalinadinu.androidquiz.clase;


public class Test {
//    private String intrebare1;
//    private String raspuns1;
//    private String intrebare2;
//    private String raspuns2;
//    private String intrebare3;
//    private String raspuns3;
//    private String intrebare4;
//    private String raspuns4;
//    private String intrebare5;
//    private String raspuns5;
    private String numeTest;
    private String nrIntrebari;

    public Test(String numeTest, String nrIntrebari) {
        this.numeTest = numeTest;
        this.nrIntrebari = nrIntrebari;
    }

    public String getNumeTest() {
        return numeTest;
    }

    public void setNumeTest(String numeTest) {
        this.numeTest = numeTest;
    }

    public String getNrIntrebari() {
        return nrIntrebari;
    }

    public void setNrIntrebari(String nrIntrebari) {
        this.nrIntrebari = nrIntrebari;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(numeTest);
        sb.append(", ");
        sb.append(nrIntrebari);
        return sb.toString();
    }
}
