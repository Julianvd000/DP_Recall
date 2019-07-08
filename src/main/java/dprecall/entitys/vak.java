package dprecall.entitys;

public class vak {
    private String Code;
    private String Naam;
    private  int ECTS;

    public String getCode () {
        return Code;
    }

    public void setCode (String code) {
        Code = code;
    }

    public String getNaam () {
        return Naam;
    }

    public void setNaam (String naam) {
        Naam = naam;
    }

    public int getECTS () {
        return ECTS;
    }

    public void setECTS (int ECTS) {
        this.ECTS = ECTS;
    }
}
