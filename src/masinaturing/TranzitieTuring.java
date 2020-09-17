package masinaturing;

public class TranzitieTuring {
    
    private String stareInceput;
    private char   caracterCitit;
    private char   caracterScris;
    private char   directie;
    private String stareSfarsit;

    public TranzitieTuring(String stareInceput, char caracterCitit, char caracterScris, char directie, String stareSfarsit) {
        this.stareInceput = stareInceput;
        this.caracterCitit = caracterCitit;
        this.caracterScris = caracterScris;
        this.directie = directie;
        this.stareSfarsit = stareSfarsit;
    }

    public String getStareInceput() {
        return stareInceput;
    }

    public char getCaracterCitit() {
        return caracterCitit;
    }

    public char getCaracterScris() {
        return caracterScris;
    }

    public char getDirectie() {
        return directie;
    }

    public String getStareSfarsit() {
        return stareSfarsit;
    }

    public void setStareInceput(String stareInceput) {
        this.stareInceput = stareInceput;
    }

    public void setCaracterCitit(char caracterCitit) {
        this.caracterCitit = caracterCitit;
    }

    public void setCaracterScris(char caracterScris) {
        this.caracterScris = caracterScris;
    }

    public void setDirectie(char directie) {
        this.directie = directie;
    }

    public void setStareSfarsit(String stareSfarsit) {
        this.stareSfarsit = stareSfarsit;
    }

    @Override
    public String toString() {
        return stareInceput + " "+ caracterCitit + " "+caracterScris +" " + directie + " " + stareSfarsit;
    }
    
    
    
            
}
