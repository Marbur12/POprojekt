import java.util.ArrayList;

public class Druzyna {
    private String nazwa;
    private final ArrayList<Gracz> zawodnicy = new ArrayList<Gracz>();
    private int zwyciestwa = 0;
    Druzyna(String n){
        nazwa = n;
    }
    Druzyna(Druzyna d){
        nazwa=d.nazwa;
        zwyciestwa= d.zwyciestwa;
        zawodnicy.addAll(d.zawodnicy);
    }
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

    @Override
    public String toString() {
        return nazwa;
    }
}
