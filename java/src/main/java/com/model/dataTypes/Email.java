package com.model.dataTypes;

public class Email {

    String adresse;
    String host;
    String gesamteEmail;

    public Email(String email){
        gesamteEmail = email;
    }

    public Email(){

    }
    public Email(String adresse, String host){
        this.adresse = adresse;
        this.host = host;
    }

    public String getGesamteEmail(){
        return gesamteEmail;
    }

    public String getAdresse(){
        return adresse;
    }

    public String getHost(){
        return host;
    }

    public void ueberpruefeEmail(){
        // TODO missing code in methode ueberpruefeEmail

    }
}