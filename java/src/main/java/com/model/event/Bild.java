package com.model.event;

public class Bild {

    String DateiPfad;
    String Name;

    public Bild(){}

    public Bild(String name, String dateiPfad){

    }

    public String ToString(){
        return "some important string";
    }

    public String getDateiPfad(){
        return this.DateiPfad;
    }
    public void setDateiPfad(String dateiPfad){
        this.DateiPfad = dateiPfad;
    }
    public String getName(){
        return this.Name;
    }
    public void setName(String name){
        this.Name = name;
    }
}
