package com.databaseInterface;
import com.model.event.*;
import java.util.ArrayList;
import com.model.dataTypes.*;
import com.model.person.*;

public interface Export {

    public void exportHauptevent(ArrayList<Hauptevent> haupteventList);
    public void exportMitarbeiter(ArrayList<Mitarbeiter> haupteventList);
    public void exportHilfsmittel(ArrayList<Hilfsmittel> haupteventList);
    public void exportKunden(ArrayList<Kunde> kundenList);

    public void exportAll(ArrayList<Hauptevent> haupteventList, ArrayList<Mitarbeiter> mitarbeiterList, ArrayList<Hilfsmittel> hilfsmittelList, ArrayList<Kunde> kundenList);
}
