package dprecall.entitys;

import java.sql.Date;
import java.util.List;

public class student {
    private int id;
    private String Naam;
    private Date gbdatum = null;
    private klas klas_code;

    public List<vak> getVakken () {
        return vakken;
    }

    public void setVakken (List<vak> vakken) {
        this.vakken = vakken;
    }

    private List<vak> vakken;

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

    public klas getKlas_code () {
        return klas_code;
    }

    public void setKlas_code (klas klas_code) {
        this.klas_code = klas_code;
    }

    @Override
    public String toString () {
        if (this.vakken == null){
            return this.getNaam() + "zit in " + this.getKlas_code().toString();
        }else{
            String allevakken = "";
            for (vak vak: vakken) {
                allevakken += vak.toString();
            }
            return this.getNaam() + " zit in " + this.getKlas_code().toString() +" en heeft de vakken "+ allevakken;
        }

    }
}
