import java.util.ArrayList;

public final class MeczSiatkowki extends Mecz{
    private Sedzia_pomocniczy pom1, pom2;
    MeczSiatkowki(Druzyna d0, Druzyna d1,Sedzia s, Sedzia_pomocniczy sp1, Sedzia_pomocniczy sp2){
        super(d0,d1,s);
        pom1 = new Sedzia_pomocniczy(sp1);
        pom2 = new Sedzia_pomocniczy(sp2);
    }
    /*
    public void wynik(int wynik1, int wynik2, Sedzia s, Sedzia_pomocniczy p1, Sedzia_pomocniczy p2){
        sedzia=new Sedzia(s);
        pom1=new Sedzia_pomocniczy(pom1);
        pom2=new Sedzia_pomocniczy(pom2);
        czyRozegrany=true;
        if(wynik1>wynik2){
            druzyna0.wygrana();
        }
        if(wynik1<wynik2){
            druzyna1.wygrana();
        }
        if(wynik1==wynik2){
            System.out.println("Mecz zakonczyl sie remisem!");
        }
    }*/
    //gopnik: imo mozna wyjebac te funkcje? pewnie jeszcze tutaj rzeczy mozna zmienic
    public void modSedziPomocniczych(Sedzia_pomocniczy s1, Sedzia_pomocniczy s2){
        pom1 = s1;
        pom2 = s2;
    }
    public ArrayList<Sedzia_pomocniczy> getSedzia_pomocniczy(){
        ArrayList<Sedzia_pomocniczy> sedziowie_pomoc =new ArrayList<Sedzia_pomocniczy>();
        sedziowie_pomoc.add(pom1);
        sedziowie_pomoc.add(pom2);
        return sedziowie_pomoc;
        //(zjebane)->chyba fixed
    }
}
