import java.util.Scanner;

abstract class Mecz {
    protected Sedzia sedzia;
    protected Druzyna druzyna0, druzyna1;
    protected int zwyciezca;
    protected boolean czyRozegrany;
    Mecz(Druzyna d0, Druzyna d1){
        druzyna0=d0;
        druzyna1=d1;
    }
    public void wynik(){
        System.out.println("Prosze podaj wyniki: (jesli byl remis, podaj wyniki dogrywki)\nWynik 1:");
        Scanner myObj = new Scanner(System.in);
        int wynik1 = myObj.nextInt();
        System.out.println("Wynik 2:");
        int wynik2 = myObj.nextInt();
        System.out.println("Podaj dane sedziego\nImie: ");
        myObj = new Scanner(System.in);
        String imie = myObj.nextLine();
        System.out.println("Nazwisko: ");
        String nazwisko = myObj.nextLine();
        sedzia=new Sedzia(imie, nazwisko);
        czyRozegrany=true;
        if(wynik1>wynik2){
            zwyciezca=0;
            druzyna0.wygrana();
        }
        if(wynik1<wynik2){
            zwyciezca=1;
            druzyna1.wygrana();
        }
        if(wynik1==wynik2){
            //nie możemy mieć remisów, trzeba napisać dogrywke czy coś
            //gopnik: jedyne co trzeba to wyjebac ten przypadek ( ͡° ͜ʖ ͡°)
            System.out.println("Mecz zakonczyl sie remisem!");
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
