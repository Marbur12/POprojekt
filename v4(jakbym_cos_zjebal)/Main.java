import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.util.InputMismatchException;

public class Main{
    /*funkcja odpowiada za wyswietlenie zarzadzania konkretnymi listami, case1 to zarzadzanie druzynami, case2 sedziami itp
    na podstawie wczesniej podanej liczby
    uwzglednilem rowniez wypisywanie druzyn, sedziow aby mozna bylo latwiej podjac decyzje o dodaniu ew usunieciu
    */
    static Druzyna NazwaDruzyny(Kopakabana plaza){
        System.out.println("Podaj nazwe druzyny!");
        Scanner myObj = new Scanner(System.in);
        String nazwa_druzyny = myObj.nextLine();
        return new Druzyna(nazwa_druzyny);
    }
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
    
    static void wypiszopcjeSedziego(){
        System.out.println("Wybierz co chcesz zrobic");
        System.out.println("1.Dodaj sedziego");
        System.out.println("2.Dodaj sedziego pomocniczego");
        System.out.println("3.Usun sedziego");
        System.out.println("4.Usun sedziego pomocniczego");
        System.out.println("5-powrot");
    }
    
    static void wypiszopcjeDruzyny(){
        System.out.println("Wybierz co chcesz zrobic");
        System.out.println("1-Zglos druzyne");
        System.out.println("2-Wycofaj druzyne");
        System.out.println("3-powrot");
    }
    static void wypiszOpcjeMeczy(){
        System.out.println("Co chcesz zrobic?");
        System.out.println("1.Generuj mecze");
        System.out.println("2.Generuj polfinaly");
        System.out.println("3.Generuj finaly");
        System.out.println("4.powrot");
    }
    static void wypiszMenu(){
        System.out.println("Co chcesz zrobic?");
        System.out.println("1-Stworz liste druzyn");
        System.out.println("2-Stworz liste sedziow");
        System.out.println("3-Organizuj rozgrywki");
        System.out.println("4-Wyświetl tabele wynikow");
        System.out.println("5-Wyjdz");
    }
    //gopnik: lekki refactoring?
    
    static void wyborGlowny(int chose, Kopakabana plaza){
        int i;
        switch (chose){
            case 1:
                i=1;
                System.out.println("Oto lista druzyn");
                plaza.wypiszDruzyny();
                wypiszopcjeDruzyny();
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
                wypiszopcjeSedziego();
                myObj = new Scanner(System.in);
                wybor_uzytkownika = myObj.nextInt();
                do{
                    wyborSedzia(wybor_uzytkownika, plaza);
                    wybor_uzytkownika = myObj.nextInt();
                }while(wybor_uzytkownika!=5);
                break;
            case 3:
                i=1;
                wypiszOpcjeMeczy();
                myObj = new Scanner(System.in);
                wybor_uzytkownika = myObj.nextInt();
                do{
                    wyborMecze(wybor_uzytkownika, plaza);
                    wybor_uzytkownika = myObj.nextInt();
                }while(wybor_uzytkownika!=4);
                break;
                //tutaj powinna byc funkcja odpowiadajaca za stworzenie jednego z trzech meczy
            case 4:
                try {
                    //gopnik: lapanie wyjatku oraz funkcja z sortowaniem
                    if(plaza.rozmiarDruzyn()<1 || plaza.rozmiarSedziow()<1){
                        throw new ZlaObsluga("nie podales jeszcze druzyn!");
                    }
                    if(plaza.rozmiarSedziow()<1){
                        throw new ZlaObsluga("nie podales jeszcze sedziow!");
                    }
                    plaza.sortowanie();

                }catch(ZlaObsluga z){
                    System.out.println(z.getMessage());
                }
                break;
            case 5:
                System.exit(0);
                //ustalilem ze jednak tutaj wyjsciie
            default:
                System.out.println("Podaj liczbe z odpowiedniego zakresu!");
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
        wypiszopcjeDruzyny();
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
                plaza.dodajSedziegoPomocniczego(s);
                break;

            case 3:
                sedzia = NazwaSedziego(plaza);
                plaza.usunSedziego(sedzia);
                break;
            case 4:
                s = NazwaSedziegoPom(plaza);
                plaza.usunSedziegoPomocniczego(s);
                break;
            default:
                break;
        }
         wypiszopcjeSedziego();
    }
    static void wyborMecze(int chose, Kopakabana plaza1){
        switch(chose){
            case 1:
                if(plaza1.rozmiarMeczy()==0) {
                try {
                    if (plaza1.rozmiarDruzyn() < 2){
                        throw new ZlaObsluga("zla malo druzyn");
                    }
                        plaza1.generujMecze();
                    //gopnik: w nastepnych linijkach wykorzystalem nowo napisane funkcje, jesli beda nowe bledy to najpewniej z tego powodu
                    for (int i = 0; i < plaza1.rozmiarMeczy(); i++) {
                        String typMeczu = "";
                        if (plaza1.zwrocMecz(i) instanceof Mecz2ogni)
                            typMeczu = "Mecz2ogni       ";
                        else if (plaza1.zwrocMecz(i) instanceof MeczSiatkowki)
                            typMeczu = "MeczSiatkowki   ";
                        else if (plaza1.zwrocMecz(i) instanceof PrzeciaganieLiny)
                            typMeczu = "PrzeciaganieLiny";
                        System.out.println(i + ". Mecz:" + typMeczu + " " + plaza1.zwrocMecz(i).druzyna0 + " vs " + plaza1.zwrocMecz(i).druzyna1);
                        //gopnik: imo tutaj mozna dodac proszenie o wyniki meczy a sedziow rowniez jako tako mozna losowac
                        //gopnik: zmienie nieco strukture metody wynik w klasie mecz
                        plaza1.zwrocMecz(i).wynik();
                    }
                    for (int i = 0; i < plaza1.rozmiarDruzyn(); i++) {
                        System.out.println(plaza1.zwrocDruzyne(i) + "Liczba wygranych: " + plaza1.zwrocDruzyne(i).getZwyciestwa());
                    }              
                }catch(ZlaObsluga z){
                    System.out.println("wykryto blad");
                    System.out.println(z.getMessage());
                }}else{
                System.out.println("Mecze zostaly juz wygenerowane!");
                }
                break;
            case 2:
                 if(plaza1.rozmiarPolfinaly()==0){
                    plaza1.generujPolfinaly();
                    System.out.println("Polfinaly!!!!!!");
                    for (int i = 0; i < plaza1.getMeczePolfinaly().size(); i++) {
                        String typMeczu = "";
                        if (plaza1.getMeczePolfinaly().get(i) instanceof Mecz2ogni)
                            typMeczu = "Mecz2ogni       ";
                        else if (plaza1.getMeczePolfinaly().get(i) instanceof MeczSiatkowki)
                            typMeczu = "MeczSiatkowki   ";
                        else if (plaza1.getMeczePolfinaly().get(i) instanceof PrzeciaganieLiny)
                            typMeczu = "PrzeciaganieLiny";
                        System.out.println(i + ". Mecz:" + typMeczu + " " + plaza1.getMeczePolfinaly().get(i).druzyna0 + " vs " + plaza1.getMeczePolfinaly().get(i).druzyna1);
                    }
                 }else{
                    System.out.println("Juz rozegrano polfinaly!!");
                 }
                    break;
                case 3:
                    plaza1.generujFinaly();
                break;
                    //nie wiem czy to dziala bo jeszcze nad tym nie myslalem tylko zgralem tutaj
            default:
                break;
        }
        wypiszOpcjeMeczy();
    }
        
    public static void Serializuj(Kopakabana plaza, String path) {
        FileOutputStream plik = null;
        try {
            plik = new FileOutputStream(path+".ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream wyj = null;
        try {
            wyj = new ObjectOutputStream(plik);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            wyj.writeObject(plaza);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            wyj.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            plik.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Kopakabana Deserializuj(String path){
        FileInputStream plik = null;
        try {
            plik = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(plik);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Kopakabana plaza=null;
        try {
            plaza = (Kopakabana) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            plik.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return plaza;
    }

    public static void main(String[] args) {
        try{
        //test
            /*
        Kopakabana plaza = new Kopakabana();
        plaza.zglosDruzyna(new Druzyna("Patrysie"));
        plaza.zglosDruzyna(new Druzyna("Chuje"));
        plaza.zglosDruzyna(new Druzyna("Debile"));
        plaza.zglosDruzyna(new Druzyna("Cioty"));
        plaza.zglosDruzyna(new Druzyna("Farfocle"));
        plaza.dodajSedziego(new Sedzia("Tfuj", "Stary"));
        plaza.dodajSedziegoPomocniczego(new Sedzia_pomocniczy("Jest","Jebanmy"));
        plaza.dodajSedziegoPomocniczego(new Sedzia_pomocniczy("Jest","jkasfd"));
        Serializuj(plaza, "hui");
        //gopnik: w nastepnych linijkach wykorzystalem nowo napisane funkcje, jesli beda nowe bledy to najpewniej z tego powodu
       //gopnik: przenioslem te generacje meczy i polfinalow do wyborMecze
*/
        //end test
        //concluding działa zostawiam gdyby moduł przydał się na przyszłość

        System.out.println("Witaj w zawodach plaży Kopakabana!");
        int wybor=0;
        Scanner myObj = new Scanner(System.in);
        String nazwa_druzyny, imie, nazwisko;
        //Kopakabana plaza = new Kopakabana();
        Kopakabana plaza = null;
        plaza = Deserializuj("hui.ser");
        while(true) {
            wypiszMenu();
            wybor = myObj.nextInt();
            wyborGlowny(wybor, plaza);
            //gopnik: funkcja wybor glowny decyduje czy bedziemy zarzadzac druzynami, sedziami czy inne opcje
            }
        }catch(InputMismatchException e){
            System.out.println("podaj liczbe!");
        }
        //gopnik: no kolejny wyjatek
    }
}
