package dprecall.entitys;

public class klas {
    private String Code;
    private String Mentor;
    private int Startjaar;

    public String getCode () {
        return Code;
    }

    public void setCode (String code) {
        Code = code;
    }

    public String getMentor () {
        return Mentor;
    }

    public void setMentor (String mentor) {
        Mentor = mentor;
    }

    public int getStartjaar () {
        return Startjaar;
    }

    public void setStartjaar (int startjaar) {
        Startjaar = startjaar;
    }

    @Override
    public String toString () {
        String returnString = "";
        returnString +=  "de klas " + this.getCode();
        if(this.getMentor() != null ){returnString += "heeft de mentor" +this.getMentor();}
        returnString += " en begonnen in " + this.getStartjaar();
        return returnString;
    }
}
