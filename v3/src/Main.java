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
                for(Druzyna druzyna : plaza.druzyny){
                    System.out.println(i+"."+druzyna);
                    i++;
                }
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
                myObj = new Scanner(System.in);
                wybor_uzytkownika = myObj.nextInt();
                do{
                    wyborSedzia(wybor_uzytkownika, plaza);
                    wybor_uzytkownika = myObj.nextInt();
                }while(wybor_uzytkownika!=5);
                break;
            case 3:
                i=1;
                System.out.println("Jaki mecz chcesz zorganizować?");
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
        Druzyna d = new Druzyna(nazwa_druzyny);
        return d;
    }
    //analogicznie zrobilem z NazwaSedziego jak i NazwaSedziegoPom
    static Sedzia NazwaSedziego(Kopakabana plaza){
        System.out.println("Podaj imie sedziego");
        Scanner myObj = new Scanner(System.in);
        String imie = myObj.nextLine();
        System.out.println("Podaj nazwisko sedziego");
        String nazwisko = myObj.nextLine();
        Sedzia sedzia = new Sedzia(imie, nazwisko);
        return sedzia;
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
                int i = 1;
                System.out.println("Wybierz numery druzyn ktore rozegraly mecz");
                for(Druzyna druzyna : plaza.druzyny) {
                    System.out.println(i + "." + druzyna);
                    i++;
                }
                System.out.println("Numer pierwszej druzyny:");
                Scanner myObj = new Scanner(System.in);
                int wybor = myObj.nextInt();
                wybor -= 1;
                Druzyna d1 = plaza.odczytaj(wybor);
                System.out.println("Numer drugiej druzyny:");
                wybor = myObj.nextInt();
                wybor -= 1;
                Druzyna d2 = plaza.odczytaj(wybor);
                System.out.println("Wybierz numer sedziego ktory sedziowal mecz");
                i=1;
                for(Sedzia sedzia : plaza.sedziowie) {
                    System.out.println(i + "." + sedzia);
                    i++;
                }
                wybor = myObj.nextInt();
                wybor -= 1;
                Sedzia s1 = plaza.read(wybor);
                System.out.println("Podaj odpowiednio wyniki");
                System.out.println("Wynik 1:");
                int wynik1 = myObj.nextInt();
                System.out.println("Wynik 2:");
                int wynik2 = myObj.nextInt();
                Mecz2ogni mecz2ogni = new Mecz2ogni(d1, d2, s1);
                mecz2ogni.wynik(wynik1,wynik2);
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
            wyborGlowny(wybor, plaza);
            //funkcja wybor glowny decyduje czy bedziemy zarzadzac druzynami, sedziami czy inne opcje
        }
    }
}
