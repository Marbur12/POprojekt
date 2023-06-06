import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Kopakabana {
    public ArrayList<Sedzia> sedziowie = new ArrayList<Sedzia>();
    public ArrayList<Mecz> mecze = new ArrayList<Mecz>();
    public ArrayList<Druzyna> druzyny = new ArrayList<Druzyna>();
    private ArrayList<Mecz> meczePolfinaly = new ArrayList<Mecz>();
    private ArrayList<Mecz> meczeFinaly = new ArrayList<Mecz>();
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
    public ArrayList<Mecz> getMeczePolfinaly(){return meczePolfinaly;}
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

    public void generujPolfinaly(){

        //dodaje druzyny z najwieksza liczba zwyciezc do nowej
        //listy z ktorej beda tworzone polfinaly
        int liczdruz=0;
        ArrayList<Druzyna> top= new ArrayList<Druzyna>();
        druzyny.sort(new Comparator<Druzyna>() {
            @Override
            public int compare(Druzyna o1, Druzyna o2) {
                return o2.getZwyciestwa()-o1.getZwyciestwa();
            }
        });
        int topzw=druzyny.get(0).getZwyciestwa();
        while (liczdruz<4){
            for (Druzyna druzyna : druzyny) {
                if (druzyna.getZwyciestwa() == topzw) {
                    top.add(druzyna);
                    liczdruz++;
                }
            }
            topzw--;
        }

        //jako że trzeba mieć szczęsście żeby wygrywać turnieje to
        //losuje ktore drużyny dotrą do półfinałów z tych
        //które się kwalifikują ale mają najmniej zwycięzc
        if (top.size()>4){
            ArrayList<Druzyna> nowytop= new ArrayList<Druzyna>();
            topzw=top.get(0).getZwyciestwa();
            int botzw=top.get(top.size()-1).getZwyciestwa();
            while (topzw!=botzw){
                nowytop.add(top.get(0));
                top.remove(0);
                topzw=top.get(0).getZwyciestwa();
            }
            Random random = new Random();
            int los;
            while (nowytop.size()<4){
                los= random.nextInt(top.size()-1);
                nowytop.add(top.get(los));
                top.remove(los);
            }
            top=nowytop;
        }
        for (Druzyna druzyna : top) {
            druzyna.setZwyciestwa(0);
        }
        for (int i=0; i<2; i++){
            meczePolfinaly.add(new Mecz2ogni(top.get(i), top.get(3-i)));
            meczePolfinaly.add(new PrzeciaganieLiny(top.get(i), top.get(3-i)));
            meczePolfinaly.add(new MeczSiatkowki(top.get(i), top.get(3-i)));
        }


    } //dont work ¯\_(ツ)_/¯
}
