import java.util.ArrayList;

public class Kopakabana {
    public ArrayList<Sedzia> sedziowie = new ArrayList<Sedzia>();
    public ArrayList<Mecz> mecze = new ArrayList<Mecz>();
    public ArrayList<Druzyna> druzyny = new ArrayList<Druzyna>();
    public void dodajSedziego(Sedzia s){
        sedziowie.add(s);
    }
    public void usunSedziego(Sedzia s){
        sedziowie.remove(s);
    }
    public void zglosDruzyna(Druzyna d){
        druzyny.add(d);
    }
    public void wycofajDruzyne(Druzyna d){
        druzyny.remove(d);
    }
    public Druzyna odczytaj_druzyne(int numer){
        return druzyny.get(numer);
    }
    public Sedzia odczytaj_sedzie(int numer){
        return sedziowie.get(numer);
    }
    public void dodajMecz(Mecz m){
        mecze.add(m);
    }
    public void usunMecz(Mecz m){
        mecze.remove(m);
    }
    public void generujMecze(){} //cos trzeba
}
