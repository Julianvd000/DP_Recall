package dprecall.entitys;

import java.util.ArrayList;
import java.util.Date;

public class student {
    private int id;
    private String Naam;
    private Date gbdatum;
    private ArrayList<klas> klas_code;

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getNaam () {
        return Naam;
    }

    public void setNaam (String naam) {
        Naam = naam;
    }

    public Date getGbdatum () {
        return gbdatum;
    }

    public void setGbdatum (Date gbdatum) {
        this.gbdatum = gbdatum;
    }

    public ArrayList<klas> getKlas_code () {
        return klas_code;
    }

    public void setKlas_code (klas klas_code) {
        this.klas_code.add(klas_code);
    }
}
