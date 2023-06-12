import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

//gopnik: tego oto uzylem do zrobienia posortowanej tablicy wedllug wynikow

public class Kopakabana {
    private ArrayList<Sedzia> sedziowie = new ArrayList<Sedzia>();
    private ArrayList<Sedzia_pomocniczy> pomocniczy = new ArrayList<Sedzia_pomocniczy>();
    //gopnik: dodatkowa lista sedziow pomocniczych jesli dziala to pomaga
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
        if(sedziowie.contains(s)) {
            sedziowie.remove(s);
        }else{
            System.out.println("Nie ma takiego sedziego!");
        }
    }
    //dodalem do usunSedziego warunek sprawdzajacy czy jest taki sedzia w ogole
    //na moje mily bajer
    public void dodajSedziegoPomocniczego(Sedzia_pomocniczy s){
        pomocniczy.add(s);
    }
    public void usunSedziegoPomocniczego(Sedzia_pomocniczy s){
        if(pomocniczy.contains(s)) {
            pomocniczy.remove(s);
        }else{
            System.out.println("Nie ma takiego sedziego!");
        }
    }
    //specjalnie pod liste sedziow pomocniczych
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
    public int rozmiarPolfinaly(){return meczePolfinaly.size();}
    //sluzy do tego aby sprawdzic czy byly juz rozegrane polfinaly
    public int rozmiarFinaly(){return meczeFinaly.size();}
    //zaraz wykorzystam ten rozmiar finalow, bo dosc niedawno dodane
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
        if(druzyny.contains(d)) {
            druzyny.remove(d);
        }else{
            System.out.println("Nie ma takiej druzyny!");
        }
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
        int size = druzyny.size();
            try {
                if (sedziowie.size() < 1 || pomocniczy.size() < 2) {
                    throw new ZlaObsluga("za malo sedziow!");
                }
                //troche sporo tych randow ale no, prowizorka
                int rand1, rand2, rand3, rand4, rand5;
                for (int i = 0; i < size - 1; i++) {
                    for (int j = i + 1; j < size; j++) {
                        rand1 = getRandomNumber(0, pomocniczy.size() - 1);
                        rand2 = getRandomNumber(0, pomocniczy.size() - 1);
                        rand3 = getRandomNumber(0, sedziowie.size() - 1);
                        rand4 = getRandomNumber(0, sedziowie.size() - 1);
                        rand5 = getRandomNumber(0, sedziowie.size() - 1);
                        mecze.add(new Mecz2ogni(druzyny.get(i), druzyny.get(j), sedziowie.get(rand3)));
                        mecze.add(new MeczSiatkowki(druzyny.get(i), druzyny.get(j), sedziowie.get(rand4), pomocniczy.get(rand1), pomocniczy.get(rand2)));
                        mecze.add(new PrzeciaganieLiny(druzyny.get(i), druzyny.get(j), sedziowie.get(rand5)));
                    }
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
        try {
            if (sedziowie.size() < 1 || pomocniczy.size() < 2) {
                throw new ZlaObsluga("za malo sedziow!");
            }
            int rand1, rand2, rand3, rand4, rand5;
            for (int i = 0; i < 2; i++) {
                rand1 = getRandomNumber(0, pomocniczy.size() - 1);
                rand2 = getRandomNumber(0, pomocniczy.size() - 1);
                rand3 = getRandomNumber(0, sedziowie.size() - 1);
                rand4 = getRandomNumber(0, sedziowie.size() - 1);
                rand5 = getRandomNumber(0, sedziowie.size() - 1);
                meczePolfinaly.add(new Mecz2ogni(top.get(i), top.get(3 - i), sedziowie.get(rand3)));
                meczePolfinaly.add(new PrzeciaganieLiny(top.get(i), top.get(3 - i), sedziowie.get(rand4)));
                meczePolfinaly.add(new MeczSiatkowki(top.get(i), top.get(3 - i), sedziowie.get(rand5), pomocniczy.get(rand1), pomocniczy.get(rand2)));
            }
        } catch (ZlaObsluga z) {
            System.out.println(z.getMessage());
            System.exit(1);
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
                int rand1, rand2, rand3, rand4, rand5;
                rand1 = getRandomNumber(0,pomocniczy.size()-1);
                rand2 = getRandomNumber(0,pomocniczy.size()-1);
                rand3 = getRandomNumber(0,sedziowie.size()-1);
                rand4 = getRandomNumber(0,sedziowie.size()-1);
                rand5 = getRandomNumber(0,sedziowie.size()-1);
                meczeFinaly.add(new Mecz2ogni(druzynyFinaly.get(i), druzynyFinaly.get(3-i), sedziowie.get(rand3)));
                meczeFinaly.add(new PrzeciaganieLiny(druzynyFinaly.get(i), druzynyFinaly.get(3-i), sedziowie.get(rand4)));
                meczeFinaly.add(new MeczSiatkowki(druzynyFinaly.get(i), druzynyFinaly.get(3-i), sedziowie.get(rand5),  pomocniczy.get(rand1), pomocniczy.get(rand2)));
            }
        //tak jak pisalem wyzej w komentarzu, nieco tych randow jest ale co zrobic
    }
}
