import java.util.ArrayList;

public class Druzyna {
    private String nazwa;
    Druzyna(String n){
        nazwa = n;
    }
    private int zwyciestwa = 0;
    Druzyna(Druzyna d){nazwa=d.nazwa;}
    private ArrayList<Gracz> zawodnicy = new ArrayList<Gracz>();
    public void modNazwa(String n){
        nazwa = n;
    }
    public void wygrana(){
        zwyciestwa += 1;
    }
    public void DodajGracza(Gracz z){
        zawodnicy.add(z);
    }
    public void usunGracza(Gracz z){
        zawodnicy.remove(z);
    }
    public ArrayList<Gracz> getGracze(){
        return zawodnicy;
    }
}
