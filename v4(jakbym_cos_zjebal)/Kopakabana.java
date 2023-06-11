import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

//gopnik: tego oto uzylem do zrobienia posortowanej tablicy wedllug wynikow

public class Kopakabana {
    private ArrayList<Sedzia> sedziowie = new ArrayList<Sedzia>();
    private ArrayList<Mecz> mecze = new ArrayList<Mecz>();
    private ArrayList<Druzyna> druzyny = new ArrayList<Druzyna>();
    private ArrayList<Druzyna> druzynyPolfinaly = new ArrayList<Druzyna>();
    private ArrayList<Druzyna> druzynyFinaly = new ArrayList<Druzyna>();
    private ArrayList<Mecz> meczePolfinaly = new ArrayList<Mecz>();
    private ArrayList<Mecz> meczeFinaly = new ArrayList<Mecz>();
    
    //gopnik: szybkie random number do generowania sedziow
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    //wspomniane sortowanie
    public void sortowanie(){
        druzyny.sort(new porownanieWynikow());
        for(Druzyna druzyna : druzyny){
            System.out.println(druzyna.toString()+":"+druzyna.getZwyciestwa());
        }
    }
    public void dodajSedziego(Sedzia s){
        sedziowie.add(s);
    }
    public void usunSedziego(Sedzia s){
        sedziowie.remove(s);
    }

    //od tego momentu do nastepnego komentarza oznaczam funkcje ktore na moje rozwiazuja problem pol private/public
    public void wypiszDruzyny(){
        int i=1;
        for(Druzyna druzyna : druzyny) {
            System.out.println(i + "." + druzyna);
            i++;
        }
    }
    public int rozmiarDruzyn(){
        return druzyny.size();
    }
    public Druzyna zwrocDruzyne(int i){
        return druzyny.get(i);
    }
    public int rozmiarSedziow(){
        return sedziowie.size();
    }
    //gopnik: bylo mi potrzebne
    public void wypiszSedziow(){
        int i=1;
        for(Sedzia sedzia : sedziowie){
            System.out.println(i + "." + sedzia);
            i++;
        }
    }
    public int rozmiarMeczy(){
        return mecze.size();
    }
    public Mecz zwrocMecz(int i){
        return mecze.get(i);
    }
    //no to dotad pisalem
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
    //gopnik: imo mozna niektore z tych szarakow wyjebac
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
        //gopnik: tutaj widac w miare obsluge bledu oraz losowanie sedziow do meczy
        //tzw mechanizm antykorupcyjny (komputer sam decyduje kto co i jak sedziuje a nie jakies ustawki)
            try {
                if (sedziowie.size() < 1) {
                    throw new ZlaObsluga("za malo sedziow!");
                }
                int i = 0;
                while (i < mecze.size() - 1) {
                    mecze.get(i).sedzia = sedziowie.get(getRandomNumber(0, sedziowie.size()));
                    if (mecze.get(i) instanceof MeczSiatkowki) {
                        //mecze.get(i)
                        //O TU O TRZEBA COS POMYSLEC!!!!!!
                        //-------------------------------------------------------------------------------------------------------------------------------------------------------
                    }
                    i++;
                }
            } catch (ZlaObsluga z) {
                System.out.println(z.getMessage());
                System.exit(1);
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
        for (int i=0;i<top.size();i++) {
            druzynyPolfinaly.add(new Druzyna(top.get(i)));
            druzynyPolfinaly.get(i).setZwyciestwa(0);
        }
        for (int i=0; i<2; i++){
            meczePolfinaly.add(new Mecz2ogni(druzynyPolfinaly.get(i), druzynyPolfinaly.get(3-i)));
            meczePolfinaly.add(new PrzeciaganieLiny(druzynyPolfinaly.get(i), druzynyPolfinaly.get(3-i)));
            meczePolfinaly.add(new MeczSiatkowki(druzynyPolfinaly.get(i), druzynyPolfinaly.get(3-i)));
        }
    }

    public void generujFinaly() {
        druzynyPolfinaly.sort(new Comparator<Druzyna>() {
            @Override
            public int compare(Druzyna o1, Druzyna o2) {
                return o2.getZwyciestwa() - o1.getZwyciestwa();
            }
        });
        for (int i=0;i<2;i++) {
            druzynyFinaly.add(new Druzyna(druzynyPolfinaly.get(i)));
            druzynyFinaly.get(i).setZwyciestwa(0);
        }
        for (int i=0; i<2; i++){
            meczeFinaly.add(new Mecz2ogni(druzynyFinaly.get(i), druzynyFinaly.get(3-i)));
            meczeFinaly.add(new PrzeciaganieLiny(druzynyFinaly.get(i), druzynyFinaly.get(3-i)));
            meczeFinaly.add(new MeczSiatkowki(druzynyFinaly.get(i), druzynyFinaly.get(3-i)));
        }
    }
}
