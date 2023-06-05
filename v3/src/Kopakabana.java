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
    public void generujMecze(){
        //generuje mecze z wszystkimi druzynami
        //returnuje ci liste wszytskich meczy
        //w menu pózniej proszisz o wyniki
        int size=druzyny.size();
        for(int i=0; i<size-1; i++) {
            for (int j = i+1; j < size; j++) {
                mecze.add(new Mecz2ogni(druzyny.get(i), druzyny.get(j)));
                mecze.add(new MeczSiatkowki(druzyny.get(i), druzyny.get(j)));
                mecze.add(new PrzeciaganieLiny(druzyny.get(i), druzyny.get(j)));
            }
        }
    } //cos trzeba
    public void generujPolfinaly(){} //cos trzeba
}
