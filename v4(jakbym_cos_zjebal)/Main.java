import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;



public class Main {
    /*funkcja odpowiada za wyswietlenie zarzadzania konkretnymi listami, case1 to zarzadzanie druzynami, case2 sedziami itp
    na podstawie wczesniej podanej liczby
    uwzglednilem rowniez wypisywanie druzyn, sedziow aby mozna bylo latwiej podjac decyzje o dodaniu ew usunieciu
    */
    static void wyborGlowny(int chose, Kopakabana plaza){
        int i;
        switch (chose){
            case 1:
                i=1;
                System.out.println("Oto lista druzyn");
                plaza.wypiszDruzyny();
                System.out.println("Wybierz co chcesz zrobic");
                System.out.println("1-Zglos druzyne");
                System.out.println("2-Wycofaj druzyne");
                System.out.println("3-powrot");
                Scanner myObj = new Scanner(System.in);
                int wybor_uzytkownika = myObj.nextInt();
                do{
                    wyborDruzyna(wybor_uzytkownika, plaza);
                    wybor_uzytkownika = myObj.nextInt();
                }while(wybor_uzytkownika!=3);
                break;
            case 2:
                i=1;
                System.out.println("Oto lista sedziow");
                plaza.wypiszSedziow();
                myObj = new Scanner(System.in);
                wybor_uzytkownika = myObj.nextInt();
                do{
                    System.out.println("Wybierz co chcesz zrobic");
                    System.out.println("1.Dodaj sedziego");
                    System.out.println("2.Dodaj sedziego pomocniczego");
                    System.out.println("3.Usun sedziego");
                    System.out.println("4.Usun sedziego pomocniczego");
                    System.out.println("5-powrot");
                    wyborSedzia(wybor_uzytkownika, plaza);
                    wybor_uzytkownika = myObj.nextInt();
                }while(wybor_uzytkownika!=5);
                break;
            case 3:
                i=1;
                System.out.println("Co chcesz zrobic?");
                System.out.println("1.Dwoch ogni");
                System.out.println("2.Mecz siatkowki");
                System.out.println("3.Przeciaganie liny");
                //tutaj powinna byc funkcja odpowiadajaca za stworzenie jednego z trzech meczy
        }
    }
    //funkcja NazwaDruzyny skraca kod, zrobilem ja po to aby nie pisac tego kodu za kazdym razem
    //kiedy chcemy zglosic, usunac druzyne itp
    static Druzyna NazwaDruzyny(Kopakabana plaza){
        System.out.println("Podaj nazwe druzyny!");
        Scanner myObj = new Scanner(System.in);
        String nazwa_druzyny = myObj.nextLine();
        return new Druzyna(nazwa_druzyny);
    }
    //analogicznie zrobilem z NazwaSedziego jak i NazwaSedziegoPom
    static Sedzia NazwaSedziego(Kopakabana plaza){
        System.out.println("Podaj imie sedziego");
        Scanner myObj = new Scanner(System.in);
        String imie = myObj.nextLine();
        System.out.println("Podaj nazwisko sedziego");
        String nazwisko = myObj.nextLine();
        return new Sedzia(imie, nazwisko);
    }
    static Sedzia_pomocniczy NazwaSedziegoPom(Kopakabana plaza){
        System.out.println("Podaj imie sedziego pomocniczego");
        Scanner myObj = new Scanner(System.in);
        String imie = myObj.nextLine();
        System.out.println("Podaj nazwisko sedziego pomocniczego");
        String nazwisko = myObj.nextLine();
        Sedzia_pomocniczy sedzia = new Sedzia_pomocniczy(imie, nazwisko);
        return sedzia;
    }
    /*co do funkcji wyborMeczu, wlasnie nie wiem co z nia zrobic, ogolnie problem polega na tym
    * ze jest to dosc duzy blok kodu, ktory ma za zadanie zebrac dane potrzebne do stworzenia meczu
    * typu nazwy druzyn ktore beda grac, nazwiska sedziow, wynik itp, problem polega na tym ze
    * zeby zorganizowac to w funkcji musielibysmy zwrocic kilka roznych obiektow etc (nie wiem czy
    * rzutowanie w gore lub dol to rozwiaze, bo srednio to umiem) do tego dochodzi problem z sedziami
    * pomocniczymi ktorzy wystepuja w klasie meczu siatkowki, imo mozna jedynie ukrocic ten caly jebitny
    * blok, chyba ze ty masz jakis pomysl na zabawe z tymi funkcjami
    * */
    static void wyborMeczu(int chose, Kopakabana plaza){
        switch(chose){
            case 1:
                /*
                int i = 1;
                System.out.println("Wybierz numery druzyn ktore rozegraly mecz");
                plaza.wypiszDruzyny();
                System.out.println("Numer pierwszej druzyny:");
                Scanner myObj = new Scanner(System.in);
                int wybor = myObj.nextInt();
                wybor -= 1;
                Druzyna d1 = plaza.odczytaj_druzyne(wybor);
                System.out.println("Numer drugiej druzyny:");
                wybor = myObj.nextInt();
                wybor -= 1;
                Druzyna d2 = plaza.odczytaj_druzyne(wybor);
                System.out.println("Wybierz numer sedziego ktory sedziowal mecz");
                i=1;
                plaza.wypiszSedziow();
                wybor = myObj.nextInt();
                wybor -= 1;
                Sedzia s1 = plaza.odczytaj_sedzie(wybor);
                System.out.println("Podaj odpowiednio wyniki");
                System.out.println("Wynik 1:");
                int wynik1 = myObj.nextInt();
                System.out.println("Wynik 2:");
                int wynik2 = myObj.nextInt();
                Mecz2ogni mecz2ogni = new Mecz2ogni(d1, d2);
                mecz2ogni.wynik(wynik1, wynik2, s1);
                //jak widzisz duzo kodu sie powtarza, ogolnie zasada prosta, wypisuje na ekran
                //wszystkie druzyny, po czym pyta o numer druzyny ktora ma rozegrac mecz,
                //podobnie robi z sedziami a pozniej leca wyniki
                break;
                //tutaj na dole powinien byc przypadek dotyczacy innnych rodzajow meczu ale no
                //jak wspomnialem wczesniej, nie mam pomyslu
            case 2:
                break;
            case 3:
                break;
            default:
                break;
                */
        }
    }
    //funkcja wyborDruzyna odpowiada, za zgloszenie lub wycofanie druzyny, przy czym wykorzystalem
    //wczesniej opisana funkcje nazwaDruzyny aby skrocic kod
    static void wyborDruzyna(int chose, Kopakabana plaza){
        switch(chose){
            case 1:
                Druzyna d = NazwaDruzyny(plaza);
                plaza.zglosDruzyna(d);
                break;
            case 2:
                d = NazwaDruzyny(plaza);
                plaza.wycofajDruzyne(d);
                break;
            default:
                break;
        }
    }
    //funkcja wyborSedzia odpowiada za dodanie lub usuniecie sedziego, przy czym wykorzystalem
    //wczesniej opisana funkcje nazwaSedziego aby skrocic kod
    static void wyborSedzia(int chose, Kopakabana plaza){
        switch(chose){
            case 1:
                Sedzia sedzia = NazwaSedziego(plaza);
                plaza.dodajSedziego(sedzia);
                break;
            case 2:
                Sedzia_pomocniczy s = NazwaSedziegoPom(plaza);
                plaza.dodajSedziego(s);
                break;

            case 3:
                sedzia = NazwaSedziego(plaza);
                plaza.usunSedziego(sedzia);
                break;
            case 4:
                s = NazwaSedziegoPom(plaza);
                plaza.usunSedziego(s);
                break;
            default:
                break;
        }
    }
    static void wypiszMenu(){
        System.out.println("Co chcesz zrobic?");
        System.out.println("1-Stworz liste druzyn");
        System.out.println("2-Stworz liste sedziow");
        System.out.println("3-Organizuj rozgrywki");
        System.out.println("4-Wyświetl tabele wynikow");
    }

    public static void main(String[] args) {
        Kopakabana plaza1 = new Kopakabana();
        //test site
        plaza1.zglosDruzyna(new Druzyna("Patrysie"));
        plaza1.zglosDruzyna(new Druzyna("Chuje"));
        plaza1.zglosDruzyna(new Druzyna("Debile"));
        plaza1.zglosDruzyna(new Druzyna("Cioty"));
        plaza1.zglosDruzyna(new Druzyna("Farfocle"));
        plaza1.generujMecze();
        //gopnik: w nastepnych linijkach wykorzystalem nowo napisane funkcje, jesli beda nowe bledy to najpewniej z tego powodu
        for (int i=0; i<plaza1.rozmiarMeczy(); i++){
            String typMeczu = "";
            if (plaza1.zwrocMecz(i) instanceof Mecz2ogni)
                typMeczu="Mecz2ogni       ";
            else if (plaza1.zwrocMecz(i) instanceof MeczSiatkowki)
                typMeczu="MeczSiatkowki   ";
            else if (plaza1.zwrocMecz(i) instanceof PrzeciaganieLiny)
                typMeczu="PrzeciaganieLiny";
            System.out.println(i+". Mecz:"+typMeczu+" "+plaza1.zwrocMecz(i).druzyna0+" vs "+plaza1.zwrocMecz(i).druzyna1);
            //gopnik: imo tutaj mozna dodac proszenie o wyniki meczy a sedziow rowniez jako tako mozna losowac
            //gopnik: zmienie nieco strukture metody wynik w klasie mecz
            plaza1.zwrocMecz(i).wynik();
        }

        for (int i=0; i<plaza1.rozmiarDruzyn(); i++){
            System.out.println(plaza1.zwrocDruzyne(i)+"Liczba wygranych: "+plaza1.zwrocDruzyne(i).getZwyciestwa());
        }
        plaza1.generujPolfinaly();
        System.out.println("Polfinaly!!!!!!");
        for (int i=0; i<plaza1.getMeczePolfinaly().size(); i++){
            String typMeczu = "";
            if (plaza1.getMeczePolfinaly().get(i) instanceof Mecz2ogni)
                typMeczu="Mecz2ogni       ";
            else if (plaza1.getMeczePolfinaly().get(i) instanceof MeczSiatkowki)
                typMeczu="MeczSiatkowki   ";
            else if (plaza1.getMeczePolfinaly().get(i) instanceof PrzeciaganieLiny)
                typMeczu="PrzeciaganieLiny";
            System.out.println(i+". Mecz:"+typMeczu+" "+plaza1.getMeczePolfinaly().get(i).druzyna0+" vs "+plaza1.getMeczePolfinaly().get(i).druzyna1);
        }

        //end test
        //concluding działa zostawiam gdyby moduł przydał się na przyszłość

        System.out.println("Witaj w zawodach plaży Kopakabana!");
        int wybor=0;
        Scanner myObj = new Scanner(System.in);
        String nazwa_druzyny, imie, nazwisko;
        Kopakabana plaza = new Kopakabana();
        while(wybor!=5) {
            wypiszMenu();
            wybor = myObj.nextInt();
            wyborGlowny(wybor, plaza);
            //gopnik: funkcja wybor glowny decyduje czy bedziemy zarzadzac druzynami, sedziami czy inne opcje
        }
    }
}
