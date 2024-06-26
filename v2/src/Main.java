import java.util.ArrayList;
import java.util.Scanner;



public class Main {

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
        }
    }
    static Druzyna NazwaDruzyny(Kopakabana plaza){
        System.out.println("Podaj nazwe druzyny!");
        Scanner myObj = new Scanner(System.in);
        String nazwa_druzyny = myObj.nextLine();
        Druzyna d = new Druzyna(nazwa_druzyny);
        return d;
    }

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
        }
    }
}