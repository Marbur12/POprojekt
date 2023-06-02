import java.util.ArrayList;
import java.util.Scanner;

class Osoba{
    protected String imie, nazwisko;
    public Osoba(String ii, String nn){imie=ii;nazwisko=nn;}
    public Osoba(Osoba o){imie=o.imie;nazwisko=o.nazwisko;}
    public void modyfikuj(String i, String n){
        imie = i;
        nazwisko = n;
    }
    public String getDane(){
        return imie+" "+nazwisko;
    }
}

class Gracz extends Osoba{
        Gracz(String i, String n){
        super(i, n);
        }
}
class Sedzia extends Osoba{
    Sedzia(String i, String n){
        super(i,n);
    }
}

class Sedzia_pomocniczy extends Sedzia{
    Sedzia_pomocniczy(String i, String n){
        super(i,n);
    }
}

class Druzyna{
    private String nazwa;
    Druzyna(String n){
        nazwa = n;
    }
    Druzyna(Druzyna d){nazwa=d.nazwa;}
    private ArrayList<Gracz> zawodnicy = new ArrayList<Gracz>();
    public void modNazwa(String n){
        nazwa = n;
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

class Mecz{
    protected Sedzia sedzia;
    protected Druzyna druzyna0, druzyna1;
    protected int zwyciezca;
    protected boolean czyRozegrany;
    Mecz(Druzyna d0, Druzyna d1, Sedzia s, int z){
        sedzia=new Sedzia(s.imie, s.nazwisko);
        druzyna0=new Druzyna(d0);
        druzyna1=new Druzyna(d1);
        zwyciezca=z;
    }
    public void modZwyciezca(int z){
        zwyciezca = z;
    }
    public void modDruzyny(Druzyna d0, Druzyna d1){
        druzyna0 = d0;
        druzyna1 = d1;
    }
    public void modSedzie(Sedzia s){
        sedzia=s;
    }
    public Sedzia getSedzia(){
        return sedzia;
    }
    public void modCzyRozegrany(boolean t){
        czyRozegrany = t;
    }
}

final class PrzeciaganieLiny extends Mecz{
        PrzeciaganieLiny(Druzyna d0, Druzyna d1, Sedzia s, int z){
            super(d0,d1,s,z);
        }
}

final class Mecz2ogni extends Mecz{
    Mecz2ogni(Druzyna d0, Druzyna d1, Sedzia s, int z){
        super(d0,d1,s,z);
    }
}

final class MeczSiatkowki extends Mecz{
    private Sedzia_pomocniczy pom1, pom2;
    MeczSiatkowki(Druzyna d0, Druzyna d1, Sedzia s, int z){
        super(d0,d1,s,z);
    }
    public void modSedziPomocniczych(Sedzia_pomocniczy s1, Sedzia_pomocniczy s2){
        pom1 = s1;
        pom2 = s2;
    }
    public Sedzia_pomocniczy getSedzia_pomocniczy(){
        return pom1; //zjebane
    }
}

class Kopakabana{
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
    public void dodajMecz(Mecz m){
        mecze.add(m);
    }
    public void usunMecz(Mecz m){
        mecze.remove(m);
    }
    public void generujMecze(){} //cos trzeba
}

public class Main {
    public static void main(String[] args) {
        int wybor=0;
        String nazwa_druzyny, imie, nazwisko;
        Kopakabana plaza = new Kopakabana();
        while(wybor!=5) {
            Scanner myObj = new Scanner(System.in);
            System.out.println("Witaj w zawodach plaży Kopakabana!");
            System.out.println("Co chcesz zrobic?");
            System.out.println("1-Zarządzaj drużynami");
            System.out.println("2-Zarządzaj sędziami");
            System.out.println("3-Organizuj rozgrywki");
            System.out.println("4-Wyświetl tabele wynikow");
            int wybor_uzytkownika = myObj.nextInt();
            wybor = wybor_uzytkownika;
            switch(wybor){
                case 1:
                    int i=1;
                    wybor_uzytkownika=0;
                    System.out.println("Oto lista druzyn");
                    for(Druzyna druzyna : plaza.druzyny){
                        System.out.println(i+"."+druzyna);
                        i++;
                    }
                    while(wybor_uzytkownika!=3) {
                        System.out.println("Wybierz co chcesz zrobic");
                        System.out.println("1-Zglos druzyne");
                        System.out.println("2-Wycofaj druzyne");
                        System.out.println("3-powrot");
                        myObj = new Scanner(System.in);
                        wybor_uzytkownika = myObj.nextInt();
                        switch (wybor_uzytkownika) {
                            case 1:
                                System.out.println("Podaj nazwe druzyny!");
                                myObj = new Scanner(System.in);
                                nazwa_druzyny = myObj.nextLine();
                                Druzyna d = new Druzyna(nazwa_druzyny);
                                plaza.zglosDruzyna(d);
                                break;
                            case 2:
                                System.out.println("Podaj nazwe druzyny!");
                                myObj = new Scanner(System.in);
                                nazwa_druzyny = myObj.nextLine();
                                d = new Druzyna(nazwa_druzyny);
                                plaza.wycofajDruzyne(d);
                                break;
                            default:
                                break;
                        }
                    }

                    break;
                case 2:
                    i=1;
                    System.out.println("Oto lista sedziow");
                    for(Sedzia sedzia : plaza.sedziowie) {
                        System.out.println(i + "." + sedzia);
                        i++;
                    }
                    System.out.println("Wybierz co chcesz zrobic");
                    System.out.println("1.Dodaj sedziego");
                    System.out.println("2.Dodaj sedziego pomocniczego");
                    System.out.println("3.Usun sedziego");
                    System.out.println("4.Usun sedziego pomocniczego");
                    System.out.println("5-powrot");

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:

            }
        }
    }
}