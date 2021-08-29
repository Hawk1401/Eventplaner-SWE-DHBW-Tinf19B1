package com.databaseInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.model.dataTypes.*;
import com.model.event.*;
import com.model.person.*;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileReader;

public class JSONImport implements Import{

    @Override
    public ArrayList<Hauptevent> importHauptevent() {
        // ArrayList<Hauptevent> haupteventList
        ObjectMapper objectMapper = new ObjectMapper();
        Hauptevent[] haupteventList;

        try{
            FileReader file = new FileReader("Hauptevents.json");
            haupteventList = objectMapper.readValue(file, Hauptevent[].class);
            return new ArrayList<Hauptevent>(Arrays.asList(haupteventList));
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
        return new ArrayList<Hauptevent>();
    }


    @Override
    public ArrayList<Mitarbeiter> importMitarbieter() {
        ObjectMapper objectMapper = new ObjectMapper();
        Mitarbeiter[] mitarbeiterList;

        try{
            FileReader file = new FileReader("Mitarbeiter.json");
            mitarbeiterList = objectMapper.readValue(file, Mitarbeiter[].class);
            return new ArrayList<Mitarbeiter>(Arrays.asList(mitarbeiterList));
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
        return new ArrayList<Mitarbeiter>();
    }
    
    @Override
    public ArrayList<Hilfsmittel> importHilfsmittel() {
        ObjectMapper objectMapper = new ObjectMapper();
        Hilfsmittel[] hilfsmittelList;

        try{
            FileReader file = new FileReader("Hilfsmittel.json");
            hilfsmittelList = objectMapper.readValue(file, Hilfsmittel[].class);
            return new ArrayList<Hilfsmittel>(Arrays.asList(hilfsmittelList));
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
        return new ArrayList<Hilfsmittel>();
    }

    @Override
    public ArrayList<Kunde> importKunden() {
        ObjectMapper objectMapper = new ObjectMapper();
        Kunde[] KundenList;

        try{
            FileReader file = new FileReader("Kunden.json");
            KundenList = objectMapper.readValue(file, Kunde[].class);
            return new ArrayList<Kunde>(Arrays.asList(KundenList));
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
        return new ArrayList<Kunde>();
    }


    @Override
    public Quartet<ArrayList<Hauptevent>, ArrayList<Mitarbeiter>, ArrayList<Hilfsmittel>, ArrayList<Kunde>> importAll() {
        ArrayList<Hauptevent> haupteventList = importHauptevent();
        ArrayList<Mitarbeiter> mitarbeiterList = importMitarbieter();
        ArrayList<Hilfsmittel> hilfsmittelList = importHilfsmittel();
        ArrayList<Kunde> kunden = importKunden();
        Quartet<ArrayList<Hauptevent>, ArrayList<Mitarbeiter>, ArrayList<Hilfsmittel>, ArrayList<Kunde>> tuple =  new Quartet(haupteventList, mitarbeiterList, hilfsmittelList, kunden);
        return tuple;
    }
}
