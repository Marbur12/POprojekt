import java.io.Serializable;
import java.util.Scanner;
import java.util.InputMismatchException;


abstract class Mecz implements Serializable {
    protected Sedzia sedzia;
    protected Druzyna druzyna0, druzyna1;
    protected int zwyciezca;
    protected boolean czyRozegrany;
    Mecz(Druzyna d0, Druzyna d1, Sedzia s){
        druzyna0=d0;
        druzyna1=d1;
        sedzia = s;
        
    }
    public abstract String rodzajMeczu();
    //w odpowiednich miejscach, metoda ta jest rozszerzona o wypisywanie typu danego meczu
    public void wynik(){
        try{
            System.out.println("Prosze podaj wyniki: (jesli byl remis, podaj wyniki dogrywki)\nWynik 1:");
            Scanner myObj = new Scanner(System.in);
            int wynik1 = myObj.nextInt();
            System.out.println("Wynik 2:");
            int wynik2 = myObj.nextInt();
            //to nizej zakomentowalem bo o ile sie nie myle zrezygnowalismy z tego sposobu podawania sedziow
            /* System.out.println("Podaj dane sedziego\nImie: ");
            myObj = new Scanner(System.in);
            String imie = myObj.nextLine();
            System.out.println("Nazwisko: ");
            String nazwisko = myObj.nextLine();
            sedzia=new Sedzia(imie, nazwisko);*/
                //czyRozegrany=true;
                //dodano prosta obsluge bledow, lepiej byloby zamienic ja na zwykle ify lub while
                //ale w razie czego mozna to tez tak zachowac
            if (wynik1 < 0) {
                    throw new wynikException("Ujemny wynik!", wynik1);
                }
                if (wynik2 < 0) {
                    throw new wynikException("Ujemny wynik!", wynik2);
                }
                if (wynik1 == wynik2) {
                    throw new wynikException("Brak mozliwosci remisu!", wynik1);
                }
            if(wynik1>wynik2){
                zwyciezca=0;
                druzyna0.wygrana();
            }
            if(wynik1<wynik2){
                zwyciezca=1;
                druzyna1.wygrana();
            }
        }catch(InputMismatchException s){
            System.out.println("liczba!");
            System.exit(1);
        }
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
