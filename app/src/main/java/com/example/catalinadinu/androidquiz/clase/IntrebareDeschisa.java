package com.example.catalinadinu.androidquiz.clase;

public class IntrebareDeschisa {
    private Integer id;
    private String textIntrebare;
   // private String raspunsIntrebare;
    //private Integer raspunsCorect;

    public IntrebareDeschisa(Integer id, String textIntrebare) {
        this.id = id;
        this.textIntrebare = textIntrebare;
        //this.raspunsIntrebare = raspunsIntrebare;
    }

    public IntrebareDeschisa() {
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

//    public String getRaspunsIntrebare() {
//        return raspunsIntrebare;
//    }
//
//    public void setRaspunsIntrebare(String raspunsIntrebare) {
//        this.raspunsIntrebare = raspunsIntrebare;
//    }


    @Override
    public String toString() {
        return "IntrebareDeschisa{" +
                "id=" + id +
                ", textIntrebare='" + textIntrebare + '\'' +
                ", raspunsIntrebare='" +
                '}';
    }
}
