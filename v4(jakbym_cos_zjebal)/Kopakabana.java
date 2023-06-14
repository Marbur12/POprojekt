import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;


public class Kopakabana implements Serializable {
    private final ArrayList<Sedzia> sedziowie = new ArrayList<Sedzia>();
    private final ArrayList<Sedzia_pomocniczy> pomocniczy = new ArrayList<Sedzia_pomocniczy>();
    //gopnik: dodatkowa lista sedziow pomocniczych jesli dziala to pomaga
    private final ArrayList<Mecz> mecze = new ArrayList<Mecz>();
    private final ArrayList<Druzyna> druzyny = new ArrayList<Druzyna>();
    private final ArrayList<Druzyna> druzynyPolfinaly = new ArrayList<Druzyna>();
    private final ArrayList<Druzyna> druzynyFinaly = new ArrayList<Druzyna>();
    private final ArrayList<Mecz> meczePolfinaly = new ArrayList<Mecz>();
    private final ArrayList<Mecz> meczeFinaly = new ArrayList<Mecz>();
    
    //metoda ta pomaga w losowaniu sedziow ktorzy odpowiadaja za dany mecz
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    //ponizsza funkcja pomaga sortowac druzyny wedlug najwiekszej liczby zwyciestw
    public void sortowanie(){
        druzyny.sort(new porownanieWynikow());
        for(Druzyna druzyna : druzyny){
            System.out.println(druzyna.toString()+":"+druzyna.getZwyciestwa());
        }
    }
    public void dodajSedziego(Sedzia s){

        if(sedziowie.size()==0){
            sedziowie.add(s);
        }else{
            int istnieje = 0;
            for(int i=0;i<sedziowie.size();i++) {
                if (sedziowie.get(i).toString().equals(s.toString())) {
                    istnieje = 1;
                }
            }if(istnieje == 0){
                sedziowie.add(s);
            }else{
                System.out.println("Taki sedzia juz istnieje");
            }
        }
    }
    public void usunSedziego(String imie, String nazwisko){
        for(int i=0;i<sedziowie.size();i++) {
            if (sedziowie.get(i).toString().equals(imie+" "+nazwisko)) {
                sedziowie.remove(i);
            }else if(i==sedziowie.size()-1){
                System.out.println("Nie ma takiego sedziego!");
            }
        }
    }
    public void dodajSedziegoPomocniczego(Sedzia_pomocniczy s){
        if(pomocniczy.size()==0){
            pomocniczy.add(s);
        }else{
            int istnieje = 0;
            for(int i=0;i<pomocniczy.size();i++) {
                if (pomocniczy.get(i).toString().equals(s.toString())) {
                    istnieje = 1;
                }
            }if(istnieje == 0){
                pomocniczy.add(s);
            }else{
                System.out.println("Taki sedzia juz istnieje!");
            }
        }
    }
    public void usunSedziegoPomocniczego(String imie, String nazwisko){
        for(int i=0;i<pomocniczy.size();i++) {
            if (pomocniczy.get(i).toString().equals(imie+" "+nazwisko)) {
                pomocniczy.remove(i);
            }else if(i==pomocniczy.size()-1){
                System.out.println("Nie ma takiego sedziego!");
            }
        }
    }
    public void wypiszDruzyny(){
        int i=1;
        if(druzyny.size()!=0){
        for(Druzyna druzyna : druzyny) {
            System.out.println(i + "." + druzyna);
            i++;
        }}else{
            System.out.println("Lista druzyn jest pusta!");
        }
    }

    public int rozmiarMeczy(){
        return mecze.size();
    }
    public Mecz zwrocMecz(int i){
        return mecze.get(i);
    }
    public void zglosDruzyna(Druzyna d){
        if(druzyny.size()==0){
            druzyny.add(d);
        }else{
        int istnieje = 0;
        for(int i=0;i<druzyny.size();i++) {
            if (druzyny.get(i).toString().equals(d.toString())) {
                istnieje = 1;
            }
        }if(istnieje == 0){
            druzyny.add(d);
            }else{
            System.out.println("Taka druzyna juz istnieje");
            }
        }
    }
    public void wycofajDruzyne(String nazwa){
        for(int i=0;i<druzyny.size();i++) {
            if (druzyny.get(i).toString().equals(nazwa)) {
                druzyny.remove(i);
            }else if(i==druzyny.size()-1){
                System.out.println("Nie ma takiej druzyny!");
            }
        }
    }
    public void wypiszSedziow(){
        if(sedziowie.size()!=0){
        int i=1;
        for(Sedzia sedzia : sedziowie){
            System.out.println(i + "." + sedzia.toString());
            i++;
        }}else{
            System.out.println("Lista sedziow jest pusta, pomoz ja wypelnic.");
        }
    }
    public void wypiszSedziowPomoczniczych(){
        if(pomocniczy.size()!=0){
        int i=1;
        for(Sedzia_pomocniczy sedzia_pom : pomocniczy){
            System.out.println(i + "." + sedzia_pom.toString());
            i++;
        }}else{
            System.out.println("Lista sedziow pomocniczych jest pusta, pomoz ja wypelnic.");
        }
    }
    //rozmiar listy meczy pozwala okreslic czy rozegrano juz dany etap turnieju
    public int rozmiarPolfinaly(){return meczePolfinaly.size();}
    public int rozmiarFinaly(){return meczeFinaly.size();}
    //sluzy do tego aby sprawdzic czy byly juz rozegrane polfinaly
    public int rozmiarDruzyn(){
        return druzyny.size();
    }
    public Druzyna zwrocDruzyne(int i){
        return druzyny.get(i);
    }
    public int rozmiarSedziow(){
        return sedziowie.size();
    }
    public ArrayList<Mecz> getMeczePolfinaly(){return meczePolfinaly;}
    public ArrayList<Mecz> getMeczeFinaly(){return meczeFinaly;}
    public void generujMecze(){
        //generuje mecze z wszystkimi druzynami
        //returnuje liste wszytskich meczy
        //w menu podaje sie wyniki
        int size = druzyny.size();
            try {
                if (sedziowie.size() < 1 || pomocniczy.size() < 2) {
                    throw new ZlaObsluga("za malo sedziow!");
                }
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
            

    } 

    public void generujPolfinaly(){

        //dodaje druzyny z najwieksza liczba zwyciezstw do nowej
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
        //tworzę nową listę druzyn które grają w półfinałach
        for (int i=0;i<top.size();i++) {
            druzynyPolfinaly.add(new Druzyna(top.get(i)));
            druzynyPolfinaly.get(i).setZwyciestwa(0);
        }
        //tworzę listę meczy półfinałowych
        try {
            if (sedziowie.size() < 1 || pomocniczy.size() < 2) {
                throw new ZlaObsluga("za malo sedziow!");
            }
            int rand1, rand2, rand3;
            for (int i = 0; i < 2; i++) {
                rand1 = getRandomNumber(0, pomocniczy.size() - 1);
                if (rand1==0)
                    rand2 = 1;
                else
                    rand2=rand1-1;
                rand3 = getRandomNumber(0, sedziowie.size() - 1);
                meczePolfinaly.add(new Mecz2ogni(top.get(i), top.get(3 - i), sedziowie.get(rand3)));
                rand3 = getRandomNumber(0, sedziowie.size() - 1);
                meczePolfinaly.add(new PrzeciaganieLiny(top.get(i), top.get(3 - i), sedziowie.get(rand3)));
                rand3 = getRandomNumber(0, sedziowie.size() - 1);
                meczePolfinaly.add(new MeczSiatkowki(top.get(i), top.get(3 - i), sedziowie.get(rand3), pomocniczy.get(rand1), pomocniczy.get(rand2)));
            }
        } catch (ZlaObsluga z) {
            System.out.println(z.getMessage());
            System.exit(1);
        }
    }

    public void generujFinaly() {
        //sortuje druzyny aby ustalić które grają w półfinałach
        //jako że każda drużyna gra po 3 mecze półfinałowe to nigdy nie będzie sytuacji
        //brzegowej kiedy więcej niż 2 drużyny mają tyle samo zwycięzc
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
                int rand1, rand2, rand3;
                rand1 = getRandomNumber(0, pomocniczy.size() - 1);
                if (rand1==0)
                    rand2 = 1;
                else
                   rand2=rand1-1; 
                rand3 = getRandomNumber(0,sedziowie.size()-1);
                meczeFinaly.add(new Mecz2ogni(druzynyFinaly.get(i), druzynyFinaly.get(3-i), sedziowie.get(rand3)));
                rand3 = getRandomNumber(0,sedziowie.size()-1);
                meczeFinaly.add(new PrzeciaganieLiny(druzynyFinaly.get(i), druzynyFinaly.get(3-i), sedziowie.get(rand3)));
                rand3 = getRandomNumber(0,sedziowie.size()-1);
                meczeFinaly.add(new MeczSiatkowki(druzynyFinaly.get(i), druzynyFinaly.get(3-i), sedziowie.get(rand3),  pomocniczy.get(rand1), pomocniczy.get(rand2)));
            }
    }
}
