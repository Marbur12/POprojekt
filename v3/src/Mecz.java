abstract class Mecz {
    protected Sedzia sedzia;
    protected Druzyna druzyna0, druzyna1;
    protected int zwyciezca;
    protected boolean czyRozegrany;
    Mecz(Druzyna d0, Druzyna d1){
        druzyna0=d0;
        druzyna1=d1;
    }
    public void wynik(int wynik1, int wynik2, Sedzia s){
        sedzia=new Sedzia(s.imie, s.nazwisko);
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
