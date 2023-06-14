import java.io.Serializable;

public class Sedzia implements Serializable {
    protected String imie, nazwisko;
    Sedzia(String i, String n){
        imie=i;
        nazwisko=n;
    }
    Sedzia(Sedzia s) {
        imie=s.imie;
        nazwisko=s.nazwisko;;
    }
    public String toString(){
        return imie+" "+nazwisko;
    }
}
