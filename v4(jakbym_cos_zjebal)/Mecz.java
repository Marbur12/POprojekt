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
        //jesli jakies errory z sedzia to moze przez to
    }
    public abstract String rodzajMeczu();
    //tutaj opcja od meczy
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
                //gopnik: dodalem prosta obsluge bledow, jesli uznasz ze trzeba jakos ladniej to zrobic to moge sie tym zajac
                //ale na te chwile imo to wystaraczajace, przy okazji zmienna czyRozegrany idzie do wyjebania chyba
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
    //gopnik: na moje mozna wyjebac ponizsze metody bo nie sa uzywane
    //wiec jak tez jestes takiego zdania to mozna kasowac
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
