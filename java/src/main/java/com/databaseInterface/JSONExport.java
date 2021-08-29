package com.databaseInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.model.dataTypes.*;
import com.model.event.*;
import com.model.person.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileWriter;

public class JSONExport implements Export{
    @Override
    public void exportHauptevent(ArrayList<Hauptevent> haupteventList) {

        String jsonInString = "";
        // Create JSON
        ObjectMapper mapper = new ObjectMapper();
        //Object to JSON in String
        try {
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(haupteventList);
            System.out.println(jsonInString);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // save JSON local
        try{
            FileWriter file = new FileWriter("Hauptevents.json");
            file.write(jsonInString);
            file.close();

        } catch (java.io.IOException e){
            e.printStackTrace();
        }


    }

    @Override
    public void exportMitarbeiter(ArrayList<Mitarbeiter> mitarbeiterList) {
        String jsonInString = "";
        // Create JSON
        ObjectMapper mapper = new ObjectMapper();
        //Object to JSON in String
        try {
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mitarbeiterList);
            System.out.println(jsonInString);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // save JSON local
        try{
            FileWriter file = new FileWriter("Mitarbeiter.json");
            file.write(jsonInString);
            file.close();

        } catch (java.io.IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void exportHilfsmittel(ArrayList<Hilfsmittel> hilfsmittelList) {
        String jsonInString = "";
        // Create JSON
        ObjectMapper mapper = new ObjectMapper();
        //Object to JSON in String
        try {
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(hilfsmittelList);
            System.out.println(jsonInString);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // save JSON local
        try{
            FileWriter file = new FileWriter("Hilfsmittel.json");
            file.write(jsonInString);
            file.close();
        } catch (java.io.IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void exportKunden(ArrayList<Kunde> kundenList) {
        String jsonInString = "";
        // Create JSON
        ObjectMapper mapper = new ObjectMapper();
        //Object to JSON in String
        try {
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(kundenList);
            System.out.println(jsonInString);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // save JSON local
        try{
            FileWriter file = new FileWriter("Kunden.json");
            file.write(jsonInString);
            file.close();
        } catch (java.io.IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void exportAll(ArrayList<Hauptevent> haupteventList,
                          ArrayList<Mitarbeiter> mitarbeiterList,
                          ArrayList<Hilfsmittel> hilfsmittelList,
                          ArrayList<Kunde> kundenList) {
        exportHauptevent(haupteventList);
        exportMitarbeiter(mitarbeiterList);
        exportHilfsmittel(hilfsmittelList);
        exportKunden(kundenList);
    }
}
